package com.cloud.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cloud.commons.dto.TbContactRequestDTO;
import com.cloud.commons.response.WebApiResult;
import com.cloud.commons.util.UuidUtil;
import com.cloud.system.api.TbContactApi;
import com.cloud.system.dto.TbUserRequestDTO;
import com.cloud.system.dto.TbUserResponseDTO;
import com.cloud.system.entity.TbContact;
import com.cloud.system.entity.TbUser;
import com.cloud.system.entity.Uuid;
import com.cloud.system.mapper.TbContactMapper;
import com.cloud.system.mapper.TbUserMapper;
import com.cloud.system.service.TbUserService;
import com.cloud.system.service.UuidService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author haoliuyang
 * @since 2021-08-24
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {
    @Autowired
    private UuidService uuidService;
    @Resource
    private TbUserMapper tbUserMapper;
    @Resource
    private TbContactMapper tbContactMapper;
    @Resource
    private TbContactApi tbContactApi;



    /**
     * 新增
     * @param img 文件
     * @param tbUserRequestDTO 请求参数DTO
     * @return 返回类型Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean create(TbUserRequestDTO tbUserRequestDTO,String img)throws Exception {
        Uuid uuid = Uuid.builder().uuid(UuidUtil.getUuid()).build();
        uuidService.insert(uuid);
        Integer id = uuid.getId();
        Date birthday = new Date(tbUserRequestDTO.getBirthday().getTime());
        TbUser tbUser = TbUser.builder()
                .id(id)
                .name(tbUserRequestDTO.getName())
                .gender(tbUserRequestDTO.getGender())
                .avatar(img)
                .birthday(birthday).build();
         Boolean result = this.insert(tbUser);
         if (!result) {
             return false;
         }
         if (tbUserRequestDTO.getRequestDTO() != null) {
             WebApiResult<Boolean> res = tbContactApi.addList(tbUserRequestDTO.getRequestDTO(),tbUser.getId());
                if (!res.getSuccess()) {
                    return false;
                }
         }
         return true;
    }

    /**
     * 用户信息详情
     * @param id 参数uuid
     * @return 返回类型TbUserResponseDTO
     */
    @Override
    public TbUserResponseDTO getById(Integer id)throws Exception {
        Uuid uuidEntity = uuidService.selectOne(new EntityWrapper<Uuid>().eq("id",id));
        EntityWrapper<TbUser> userWrapper = new EntityWrapper<>();
        userWrapper.eq("id",id);
        userWrapper.setSqlSelect("id,name,avatar,gender,if(gender=0,'男','女') as genderName,birthday");
        TbUser tbUser = selectOne(userWrapper);
//        条件查询
        EntityWrapper<TbContact> wrapper = new EntityWrapper<>();
        wrapper.eq("user_id",uuidEntity.getId());
        List<TbContact> contacts = tbContactMapper.selectList(wrapper);
        return TbUserResponseDTO.builder().id(tbUser.getId()).name(tbUser.getName()).avatar(tbUser.getAvatar())
                                          .gender(tbUser.getGender())
                                          .birthday(tbUser.getBirthday())
                                          .tbContacts(contacts)
                                          .build();
    }

    /**
     * 修改用户信息
     * @param tbUserRequestDTO 请求DTO
     * @return 返回类型boolean
     */
    @Override
    public boolean update(TbUserRequestDTO tbUserRequestDTO,String img)throws Exception {
        Date birthday = new Date(tbUserRequestDTO.getBirthday().getTime());
        TbUser tbUser = TbUser.builder().id(tbUserRequestDTO.getId()).name(tbUserRequestDTO.getName())
                                        .avatar(img)
                                        .gender(tbUserRequestDTO.getGender())
                                        .birthday(birthday)
                                        .build();
        Boolean res = updateById(tbUser);
        if (!res) {
            return false;
        }
        if (tbUserRequestDTO.getRequestDTO() != null) {
            for (TbContactRequestDTO contacts : tbUserRequestDTO.getRequestDTO()) {
                TbContactRequestDTO requestDTO = TbContactRequestDTO.builder()
                        .id(contacts.getId())
                        .info(contacts.getInfo())
                        .type(contacts.getType())
                        .userId(tbUser.getId()).build();
                WebApiResult<Boolean> result = tbContactApi.updateContact(requestDTO);
                if (!result.getSuccess()) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * 删除用户信息
     * @param id 参数uuid
     * @return 返回类型boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Integer id)throws Exception {
        Uuid uuidEntity = uuidService.selectOne(new EntityWrapper<Uuid>().eq("id",id));
//        删除用户信息
        Integer res = tbUserMapper.deleteById(id);
        if (res == 0) {
            return false;
        }
//        删除关联数据
            WebApiResult<Boolean> result = tbContactApi.deleteContact(uuidEntity.getId());
            if (!result.getSuccess()) {
                return false;
            }
//        删除关联数据
        return uuidService.deleteById(id);
    }

    /**
     * 列表查询
     * @param pageIndex 每页数量
     * @return 返回类型List<TbUserResponseVO>
     * @throws Exception 异常
     */
    @Override
    public PageInfo getList(Integer pageIndex,Integer pageSize)throws Exception {
        EntityWrapper<TbUser> wrapper = new EntityWrapper();
        wrapper.setSqlSelect("id,name,avatar,gender,if(gender=0,'男','女') as genderName,birthday");
        wrapper.orderBy("id",false);
            Page<TbUser> page = PageHelper.startPage(pageIndex,pageSize);
            List<TbUser> list = tbUserMapper.selectList(wrapper);
            PageInfo pageInfo = new PageInfo(list,pageSize);
            return pageInfo;
    }
}

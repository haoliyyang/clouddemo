package com.cloud.system.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
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
     * @param tbUserRequestDTO 请求参数DTO
     * @return 返回类型Boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean create(TbUserRequestDTO tbUserRequestDTO, String img)throws Exception {
        Uuid uuid = Uuid.builder().uuid(UuidUtil.getUuid()).build();
        uuidService.insert(uuid);
        Integer id = uuid.getId();
        Date birthday = new Date(tbUserRequestDTO.getBirthday().getTime());
        TbUser tbUser = TbUser.builder()
                .id(id)
                .name(tbUserRequestDTO.getName())
                .avatar(img)
                .gender(tbUserRequestDTO.getGender())
                .birthday(birthday).build();
         Boolean result = this.insert(tbUser);
         if (!result) {
             return false;
         }
         if (tbUserRequestDTO.getRequestDTO().size() != 0) {
             WebApiResult<Boolean> res = tbContactApi.addList(tbUserRequestDTO.getRequestDTO(),tbUser.getId());
                if (!res.getSuccess()) {
                    return false;
                }
         }
         return true;
    }

    /**
     * 用户信息详情
     * @param uuid 参数uuid
     * @return 返回类型TbUserResponseDTO
     */
    @Override
    public TbUserResponseDTO getById(String uuid)throws Exception {
        Uuid uuidEntity = uuidService.selectOne(new EntityWrapper<Uuid>().eq("uuid",uuid));
        TbUser tbUser = selectOne(new EntityWrapper<TbUser>().eq("id",uuidEntity.getId()));
//        条件查询
        EntityWrapper<TbContact> wrapper = new EntityWrapper<>();
        wrapper.eq("user_id",uuidEntity.getId());
        List<TbContact> contacts = tbContactMapper.selectList(wrapper);
        return TbUserResponseDTO.builder().id(tbUser.getId()).name(tbUser.getName()).avatar(tbUser.getAvatar())
                                          .gender(tbUser.isGender())
                                          .birthday(tbUser.getBirthday())
                                          .tbContacts(contacts)
                                          .build();
    }

    /**
     * 修改用户信息
     * @param tbUserRequestDTO 请求DTO
     * @param img 头像
     * @return 返回类型boolean
     */
    @Override
    public boolean update(TbUserRequestDTO tbUserRequestDTO, String img)throws Exception {
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
        if (tbUserRequestDTO.getRequestDTO().size() != 0) {
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
     * @param uuid 参数uuid
     * @return 返回类型boolean
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(String uuid)throws Exception {
        Uuid uuidEntity = uuidService.selectOne(new EntityWrapper<Uuid>().eq("uuid",uuid));
//        删除用户信息
        Integer res = tbUserMapper.deleteById(uuidEntity.getId());
        if (res == 0) {
            return false;
        }
//        删除关联数据
            WebApiResult<Boolean> result = tbContactApi.deleteContact(uuidEntity.getId());
            if (!result.getSuccess()) {
                return false;
            }
//        删除关联数据
        return uuidService.deleteById(uuidEntity.getId());
    }

    /**
     * 列表查询
     * @param pageSize 页数
     * @param pageIndex 每页数量
     * @return 返回类型List<TbUserResponseVO>
     * @throws Exception 异常
     */
    @Override
    public List<TbUser> getList(Integer pageSize, Integer pageIndex)throws Exception {
        if (pageSize != null && pageIndex != null) {
            Page<TbUser> page = new Page<>(pageSize,pageIndex);
           return tbUserMapper.selectPage(page,null);
        }
        Page<TbUser> page = new Page<>();
        return tbUserMapper.selectPage(page,null);
    }
}

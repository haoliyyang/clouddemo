package com.cloud.contactmanger.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cloud.commons.dto.TbContactRequestDTO;
import com.cloud.contactmanger.entity.TbContact;
import com.cloud.contactmanger.mapper.TbContactMapper;
import com.cloud.contactmanger.service.TbContactService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author haoliuyang
 * @since 2021-08-30
 */
@Service
public class TbContactServiceImpl extends ServiceImpl<TbContactMapper, TbContact> implements TbContactService {

    /**
     * 添加数据
     * @param requestDTO DTO类
     * @return 返回类型Boolean
     * @throws Exception 异常
     */
    @Override
    public Boolean add(TbContactRequestDTO requestDTO) throws Exception {
        TbContact tbContact = TbContact.builder().userId(requestDTO.getUserId())
                .type(requestDTO.getType())
                .info(requestDTO.getInfo()).build();
        return insert(tbContact);
    }

    /**
     * 批量添加数据
     * @param requestDTO DTO类
     * @return 返回类型Boolean
     * @throws Exception 异常
     */
    @Override
    public Boolean adds(List<TbContactRequestDTO> requestDTO,Integer userId) throws Exception {
        List<TbContact> list = new ArrayList<>();
        for (TbContactRequestDTO request:requestDTO) {
            TbContact tbContact = TbContact.builder()
                    .info(request.getInfo())
                    .type(request.getType())
                    .userId(userId)
                    .build();
            list.add(tbContact);
        }
        return this.insertBatch(list);
    }

    /**
     * 修改数据
     * @param requestDTO DTO类
     * @return 返回类型Boolean
     * @throws Exception 异常
     */
    @Override
    public Boolean updById(TbContactRequestDTO requestDTO) throws Exception {
        TbContact tbContact = TbContact.builder().id(requestDTO.getId())
                .type(requestDTO.getType())
                .info(requestDTO.getInfo()).build();
        return updateById(tbContact);
    }
}

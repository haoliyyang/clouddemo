package com.cloud.contactmanger.service;

import com.baomidou.mybatisplus.service.IService;
import com.cloud.commons.dto.TbContactRequestDTO;
import com.cloud.contactmanger.entity.TbContact;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author haoliuyang
 * @since 2021-08-30
 */
public interface TbContactService extends IService<TbContact> {
    /**
     * 添加数据
     * @param requestDTO DTO类
     * @return 返回类型Boolean
     * @throws Exception 异常
     */
    Boolean add(TbContactRequestDTO requestDTO) throws Exception;

    /**
     * 批量添加数据
     * @param requestDTOs DTO类
     * @param userId DTO类
     * @return 返回类型Boolean
     * @throws Exception 异常
     */
    Boolean adds(List<TbContactRequestDTO> requestDTOs,Integer userId) throws Exception;

    /**
     * 修改数据
     * @param requestDTO DTO类
     * @return 返回类型Boolean
     * @throws Exception 异常
     */
    Boolean updById(TbContactRequestDTO requestDTO) throws Exception;
}

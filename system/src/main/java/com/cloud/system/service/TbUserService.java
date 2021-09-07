package com.cloud.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.cloud.system.dto.TbUserRequestDTO;
import com.cloud.system.dto.TbUserResponseDTO;
import com.cloud.system.entity.TbUser;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author haoliuyang
 * @since 2021-08-24
 */
public interface TbUserService extends IService<TbUser> {
    /**
     *新增用户
     * @param tbUserRequestDTO 实体类参数
     * @param img 实体类参数
     * @return 返回类型Boolean
     * @throws Exception 异常
     */
    Boolean create(TbUserRequestDTO tbUserRequestDTO, String img) throws Exception;

    /**
     * 获取信息
     * @param uuid 参数
     * @return 返回类型TbUser
     * @throws Exception 异常
     */
    TbUserResponseDTO getById(String uuid) throws Exception;

    /**
     *修改用户
     * @param tbUser 实体类参数
     * @param img 头像路径
     * @return 返回类型boolean
     * @throws Exception 异常
     */
    boolean update(TbUserRequestDTO tbUser, String img) throws Exception;

    /**
     *删除用户
     * @param uuid 参数uid
     * @return 返回类型boolean
     * @throws Exception 异常
     */
    boolean delete(String uuid) throws Exception;

    /**
     *列表查询
     * @param pageSize 页数
     * @param pageIndex 每页条数
     * @return 返回类型 List<TbUser>
     * @throws Exception 异常
     */
    List<TbUser> getList(Integer pageSize, Integer pageIndex) throws Exception;

}

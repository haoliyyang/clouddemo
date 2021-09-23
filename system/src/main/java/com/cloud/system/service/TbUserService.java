package com.cloud.system.service;

import com.baomidou.mybatisplus.service.IService;
import com.cloud.system.dto.TbUserRequestDTO;
import com.cloud.system.dto.TbUserResponseDTO;
import com.cloud.system.entity.TbUser;
import com.github.pagehelper.PageInfo;

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
     * @param img 文件
     * @param tbUserRequestDTO 实体类参数
     * @return 返回类型Boolean
     * @throws Exception 异常
     */
    Boolean create(TbUserRequestDTO tbUserRequestDTO,String img) throws Exception;

    /**
     * 获取信息
     * @param id 参数
     * @return 返回类型TbUser
     * @throws Exception 异常
     */
    TbUserResponseDTO getById(Integer id) throws Exception;

    /**
     *修改用户
     * @param img 实体类参数
     * @param tbUser 实体类参数
     * @return 返回类型boolean
     * @throws Exception 异常
     */
    boolean update(TbUserRequestDTO tbUser,String img) throws Exception;

    /**
     *删除用户
     * @param id 参数uid
     * @return 返回类型boolean
     * @throws Exception 异常
     */
    boolean delete(Integer id) throws Exception;

    /**
     *列表查询
     * @param pageSize 页数
     * @param pageIndex 每页条数
     * @return 返回类型 List<TbUser>
     * @throws Exception 异常
     */
    PageInfo getList(Integer pageIndex,Integer pageSize) throws Exception;

}

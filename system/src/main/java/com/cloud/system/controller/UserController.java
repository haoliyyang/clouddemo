package com.cloud.system.controller;

import com.cloud.commons.response.WebApiResult;
import com.cloud.system.dto.TbUserRequestDTO;
import com.cloud.system.dto.TbUserResponseDTO;
import com.cloud.system.service.TbUserService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import java.util.Base64;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author haoliuyang
 * @since 2021-08-24
 */
@Api(tags = "系统管理")
@RestController
@RequestMapping("controller")
public class UserController {
    @Resource
    private TbUserService tbUserService;

    /**
     * 新增数据
     *@param file 文件
     * @param tbUserRequestDTO 实体类参数
     * @return 返回类型WebApiResult<Boolean>
     */
    @ApiOperation(value = "新增用户")
    @PostMapping("/create")
    public WebApiResult<Boolean> create(TbUserRequestDTO tbUserRequestDTO, @RequestParam(name = "file",required = false) MultipartFile file) {
        try {
            if (null == tbUserRequestDTO.getName() || "".equals(tbUserRequestDTO.getName())) {
                return WebApiResult.error("name is null");
            }
            if (null == tbUserRequestDTO.getBirthday()) {
                return WebApiResult.error("birthday is null");
            }
            if (null == tbUserRequestDTO.getGender()) {
                return WebApiResult.error("gender is null");
            }
            if (file == null) {
                return WebApiResult.error("file is null");
            }
//            String img = FileUtil.fileUpload(file);
            Base64.Encoder encoder = Base64.getEncoder();
            String img = encoder.encodeToString(file.getBytes());
            Boolean res = tbUserService.create(tbUserRequestDTO,img);
            if (res.equals(false)) {
                return WebApiResult.error("新增失败");
            }
            return WebApiResult.successMsg("新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            return WebApiResult.error("系统异常");
        }
    }

    /**
     * 查询用户信息
     *
     * @param id 参数uuid
     * @return 返回类型WebApiResult<TbUser>
     */
    @ApiOperation(value = "查询用户")
    @GetMapping("/query")
    public WebApiResult<TbUserResponseDTO> getById(Integer id) {
        try {
            if (null == id) {
                return WebApiResult.error("id is null");
            }
            TbUserResponseDTO tbUser = tbUserService.getById(id);
            return WebApiResult.successMsg("查询成功", tbUser);
        } catch (Exception e) {
            e.printStackTrace();
            return WebApiResult.exception("系统异常");
        }
    }

    /**
     * 修改用户信息
     *@param file 实体类参数
     * @param tbUser 实体类参数
     * @return 返回类型WebApiResult<Boolean>
     */
    @ApiOperation(value = "修改用户")
    @PutMapping("/update")
    public WebApiResult<Boolean> update(TbUserRequestDTO tbUser, @RequestParam(name = "file",required = false) MultipartFile file) {
        try {
            if (null == tbUser.getName() || "".equals(tbUser.getName())) {
                return WebApiResult.error("name is null");
            }
            if (null == tbUser.getId() || "".equals(tbUser.getId())) {
                return WebApiResult.error("id is null");
            }
            if (null == tbUser.getBirthday()) {
                return WebApiResult.error("birthday is null");
            }
            if (null == tbUser.getGender()) {
                return WebApiResult.error("gender is null");
            }
            if (null == file) {
                return WebApiResult.error("file is null");
            }
//            String img = FileUtilTwo.fileUpload(file);
            Base64.Encoder encoder = Base64.getEncoder();
            String img = encoder.encodeToString(file.getBytes());
            boolean res = tbUserService.update(tbUser,img);
            if (!res) {
                return WebApiResult.error("修改失败");
            }
            return WebApiResult.successMsg("修改成功");
        } catch (Exception e) {
            e.printStackTrace();
            return WebApiResult.exception("系统异常");
        }
    }

    /**
     * 删除用户信息
     *
     * @param id 参数uuid
     * @return 返回类型WebApiResult<Boolean>
     */
    @ApiOperation(value = "删除用户")
    @DeleteMapping("/delete")
    public WebApiResult<Boolean> delete(Integer id) {
        try {
            if (null == id) {
                return WebApiResult.error("uuid is null");
            }
            boolean res = tbUserService.delete(id);
            if (!res) {
                return WebApiResult.error("删除失败");
            }
            return WebApiResult.successMsg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return WebApiResult.exception("系统异常");
        }
    }

    /**
     * 列表查询
     * @param pageSize 每页条数
     * @param pageIndex 每页条数
     * @return 返回类型WebApiResult<List < TbUser>>
     */
    @ApiOperation(value = "分页查询")
    @GetMapping("/getList")
    public WebApiResult<PageInfo> getList(Integer pageIndex,Integer pageSize) {
        try {
//            List<TbUser> users = tbUserService.getList(pageIndex);
            return WebApiResult.successMsg("查询成功", tbUserService.getList(pageIndex,pageSize));
        } catch (Exception e) {
            e.printStackTrace();
            return WebApiResult.exception("系统异常");
        }
    }
}

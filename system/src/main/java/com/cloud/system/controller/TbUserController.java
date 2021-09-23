//package com.cloud.system.controller;
//
//import com.cloud.commons.response.WebApiResult;
//import com.cloud.commons.util.FileUtil;
//import com.cloud.system.dto.TbUserRequestDTO;
//import com.cloud.system.dto.TbUserResponseDTO;
//import com.cloud.system.entity.TbUser;
//import com.cloud.system.service.TbUserService;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import javax.annotation.Resource;
//import java.util.List;
//
///**
// * <p>
// * 前端控制器
// * </p>
// *
// * @author haoliuyang
// * @since 2021-08-24
// */
//@Api(tags = "系统管理")
//@RestController
////@CrossOrigin(allowCredentials = "true")
//@RequestMapping("userController")
//public class TbUserController {
//    @Resource
//    private TbUserService tbUserService;
//
//    /**
//     * 新增数据
//     *
//     * @param tbUserRequestDTO 实体类参数
//     * @param file   实体类参数
//     * @return 返回类型WebApiResult<Boolean>
//     */
//    @ApiOperation(value = "新增用户")
//    @PostMapping("/create")
//    public WebApiResult<Boolean> create(@RequestPart TbUserRequestDTO tbUserRequestDTO,
//                                        @RequestPart(value = "file",required = true) MultipartFile file) {
//        try {
//            if (null == tbUserRequestDTO.getName() || "".equals(tbUserRequestDTO.getName())) {
//                return WebApiResult.error("name is null");
//            }
//            if (null == tbUserRequestDTO.getBirthday()) {
//                return WebApiResult.error("birthday is null");
//            }
//            if (file.isEmpty()) {
//                return WebApiResult.error("file is null");
//            }
//            String img = FileUtil.fileUpload(file);
//            Boolean res = tbUserService.create(tbUserRequestDTO,img);
//            if (res.equals(false)) {
//                return WebApiResult.error("新增失败");
//            }
//            return WebApiResult.successMsg("新增成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return WebApiResult.error("系统异常");
//        }
//    }
//
//    /**
//     * 查询用户信息
//     *
//     * @param uuid 参数uuid
//     * @return 返回类型WebApiResult<TbUser>
//     */
//    @ApiOperation(value = "查询用户")
//    @PostMapping("/query")
//    public WebApiResult<TbUserResponseDTO> getById(String uuid) {
//        try {
//            if (null == uuid || "".equals(uuid)) {
//                return WebApiResult.error("uuid is null");
//            }
//            TbUserResponseDTO tbUser = tbUserService.getById(uuid);
//            return WebApiResult.successMsg("查询成功", tbUser);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return WebApiResult.exception("系统异常");
//        }
//    }
//
//    /**
//     * 修改用户信息
//     *
//     * @param tbUser 实体类参数
//     * @param file   实体类参数
//     * @return 返回类型WebApiResult<Boolean>
//     */
//    @ApiOperation(value = "修改用户")
//    @PostMapping("/update")
//    public WebApiResult<Boolean> update(@RequestPart TbUserRequestDTO tbUser, @RequestPart(value = "file",required = true) MultipartFile file) {
//        try {
//            if (null == tbUser.getName() || "".equals(tbUser.getName())) {
//                return WebApiResult.error("name is null");
//            }
//            if (null == tbUser.getId() || "".equals(tbUser.getId())) {
//                return WebApiResult.error("id is null");
//            }
//            if (null == tbUser.getBirthday()) {
//                return WebApiResult.error("birthday is null");
//            }
//            if (file.isEmpty()) {
//                return WebApiResult.error("file is null");
//            }
//            String img = FileUtil.fileUpload(file);
//            boolean res = tbUserService.update(tbUser,img);
//            if (!res) {
//                return WebApiResult.error("修改失败");
//            }
//            return WebApiResult.successMsg("修改成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return WebApiResult.exception("系统异常");
//        }
//    }
//
//    /**
//     * 删除用户信息
//     *
//     * @param uuid 参数uuid
//     * @return 返回类型WebApiResult<Boolean>
//     */
//    @ApiOperation(value = "删除用户")
//    @PostMapping("/delete")
//    public WebApiResult<Boolean> delete(String uuid) {
//        try {
//            if (null == uuid || "".equals(uuid)) {
//                return WebApiResult.error("uuid is null");
//            }
//            boolean res = tbUserService.delete(uuid);
//            if (!res) {
//                return WebApiResult.error("删除失败");
//            }
//            return WebApiResult.successMsg("删除成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return WebApiResult.exception("系统异常");
//        }
//    }
//
//    /**
//     * 列表查询
//     *
//     * @param pageSize  页数
//     * @param pageIndex 每页条数
//     * @return 返回类型WebApiResult<List < TbUser>>
//     */
////    @ApiOperation(value = "分页查询")
////    @GetMapping("/getList")
////    public WebApiResult<List<TbUser>> getList(Integer pageSize, Integer pageIndex) {
////        try {
////            List<TbUser> users = tbUserService.getList(pageSize, pageIndex);
////            return WebApiResult.successMsg("查询成功", users);
////        } catch (Exception e) {
////            e.printStackTrace();
////            return WebApiResult.exception("系统异常");
////        }
////    }
//    @ApiOperation(value = "分页查询")
//    @GetMapping("/getList")
//    public List<TbUser> getList(Integer pageSize, Integer pageIndex) {
//        try {
//            List<TbUser> users = tbUserService.getList(pageSize, pageIndex);
//            return  users;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//
//    /**
//     * 测试方法
//     * @return 返回值string
//     */
//    @GetMapping("hello")
//    public String hello() {
//        try {
//            String rest = "hello";
//            ObjectMapper mapper = new ObjectMapper();
//            String s = mapper.writeValueAsString(rest);
//            return s;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "系统异常";
//        }
//
//    }
//}

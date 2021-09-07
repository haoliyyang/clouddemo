package com.cloud.contactmanger.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.cloud.commons.dto.TbContactRequestDTO;
import com.cloud.commons.response.WebApiResult;
import com.cloud.contactmanger.entity.TbContact;
import com.cloud.contactmanger.service.TbContactService;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author haoliuyang
 * @since 2021-08-30
 */
@RestController
@RequestMapping("/tbContactController")
public class TbContactController {

    @Resource
    private TbContactService tbContactService;

    /**
     * 新增工作
     * @param tbContact DTO类
     * @return 返回类型WebApiResult<Boolean>
     */
    @ApiOperation(value = "新增工作")
    @PostMapping("/createContact")
    public WebApiResult<Boolean> createContact(@RequestBody TbContactRequestDTO tbContact) {
        try {
            if (tbContact.getUserId() == null) {
                return WebApiResult.error("userId==null");
            }
            if (StringUtils.isBlank(tbContact.getInfo())) {
                return WebApiResult.error("info==null");
            }
            if (StringUtils.isBlank(tbContact.getType())) {
                return WebApiResult.error("type==null");
            }
            Boolean res = tbContactService.add(tbContact);
            if (!res) {
                return WebApiResult.error("添加失败");
            }
            return WebApiResult.successMsg("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return WebApiResult.exception("系统异常");
        }
    }

    /**
     * 新增工作
     * @param tbContacts DTO类
     * @param userId DTO类
     * @return 返回类型WebApiResult<Boolean>
     */
    @ApiOperation(value = "批量新增工作")
    @PostMapping("/addList")
    public WebApiResult<Boolean> addList(@RequestBody List<TbContactRequestDTO> tbContacts,@RequestParam(value = "userId") Integer userId) {
        try {
            if (tbContacts.size() == 0) {
                return WebApiResult.error("tbContacts为空");
            }
            Boolean res = tbContactService.adds(tbContacts,userId);
            if (!res) {
                return WebApiResult.error("添加失败");
            }
            return WebApiResult.successMsg("添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            return WebApiResult.exception("系统异常");
        }
    }

    /**
     * 查询详情列表
     * @param userId user主键
     * @return 返回类型WebApiResult<List<TbContacts>>
     */
    @ApiOperation(value = "查询详情列表")
    @PostMapping("/findContacts")
    public WebApiResult<List<TbContact>> findContacts(Integer userId) {
        try {
            if (userId == null) {
                return WebApiResult.error("userId==null");
            }
            List<TbContact> tbContactList = tbContactService.selectList(new EntityWrapper<TbContact>().eq("user_id",userId));
            return WebApiResult.successMsg("查询成功",tbContactList);
        } catch (Exception e) {
            e.printStackTrace();
            return WebApiResult.exception("系统异常");
        }
    }

    /**
     * 修改工作
     * @param tbContact 实体类
     * @return 返回类型updateContact
     */
    @ApiOperation(value = "修改工作")
    @PostMapping("/updateContact")
    public WebApiResult<Boolean> updateContact(@RequestBody TbContactRequestDTO tbContact) {
        try {
            if (tbContact.getId() == null) {
                return WebApiResult.error("id==null");
            }
            Boolean res = tbContactService.updById(tbContact);
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
     * 删除工作
     * @param userId 主键id
     * @return 返回类型WebApiResult<Boolean>
     */
    @ApiOperation(value = "删除工作")
    @PostMapping("/deleteContact")
    public WebApiResult<Boolean> deleteContact(@RequestBody Integer userId) {
        try {
            if (userId == null) {
                return WebApiResult.error("userId==null");
            }
            Boolean res = tbContactService.delete(new EntityWrapper<TbContact>().eq("user_id",userId));
            if (!res) {
                return WebApiResult.error("删除失败");
            }
            return WebApiResult.successMsg("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return WebApiResult.exception("系统异常");
        }
    }

}

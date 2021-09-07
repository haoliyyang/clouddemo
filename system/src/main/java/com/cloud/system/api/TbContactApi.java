package com.cloud.system.api;

import com.cloud.commons.dto.TbContactRequestDTO;
import com.cloud.commons.response.WebApiResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author haoliuyang
 */
@FeignClient(name = "contactmanger")
public interface TbContactApi {

    /**
     * 远程调用新增工作接口
     * @param requestDTO 请求dto
     * @return 返回类型WebApiResult<Boolean>
     */
    @PostMapping("/tbContactController/createContact")
    WebApiResult<Boolean> createContact(@RequestBody TbContactRequestDTO requestDTO);

    /**
     * 远程调用批量新增工作接口
     * @param requestDTO 请求dto
     * @param userId 请求dto
     * @return 返回类型WebApiResult<Boolean>
     */
    @PostMapping("/tbContactController/addList")
    WebApiResult<Boolean> addList(@RequestBody List<TbContactRequestDTO> requestDTO,@RequestParam(value = "userId") Integer userId);

    /**
     * 远程调用删除工作接口
     * @param id 主键id
     * @return 返回类型WebApiResult<Boolean>
     */
    @PostMapping("/tbContactController/deleteContact")
    WebApiResult<Boolean> deleteContact(@RequestBody Integer id);

    /**
     * 远程调用更新工作接口
     * @param requestDTO 请求dto
     * @return 返回类型WebApiResult<Boolean>
     */
    @PostMapping("/tbContactController/updateContact")
    WebApiResult<Boolean> updateContact(@RequestBody TbContactRequestDTO requestDTO);

}

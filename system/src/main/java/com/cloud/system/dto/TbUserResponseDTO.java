package com.cloud.system.dto;

import com.baomidou.mybatisplus.annotations.TableField;
import com.cloud.system.entity.TbContact;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

/**
 * @author haoliuyang
 */
@Builder
@Getter
@ToString
@AllArgsConstructor
public final class TbUserResponseDTO {
    /**
     * 主键id
     */
    @ApiModelProperty(hidden = true)
    private final Integer id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名",notes = "用户名")
     private final String name;
    /**
     * 头像
     */
    @ApiModelProperty(value = "头像",notes = "头像",hidden = true)
     private final String avatar;
    /**
     * 性别
     */
    @ApiModelProperty(value = "性别",notes = "性别")
     private final Boolean gender;
    /**
     * 生日
     */
    @ApiModelProperty(value = "生日",notes = "生日")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
     private final Date birthday;

    /**
     * tbContacts
     */
    @ApiModelProperty(value = "工作",notes = "工作",hidden = true)
    @TableField(exist = false)
     private List<TbContact> tbContacts;
}

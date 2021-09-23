package com.cloud.system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Date;

/**
 * <p>
 * </p>
 * @author haoliuyang
 * @since 2021-08-24
 */
@Getter
@Builder
@AllArgsConstructor
@TableName("tb_user")
public final class TbUser implements Serializable {

    private static final long serialVersionUID = 1L;

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
    private final Integer gender;

    @ApiModelProperty(value = "性别名称",notes = "性别名称")
    @TableField(exist = false)
    private final String genderName;
    /**
     * 生日
     */
    @ApiModelProperty(value = "生日",notes = "生日")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private final Date birthday;
}

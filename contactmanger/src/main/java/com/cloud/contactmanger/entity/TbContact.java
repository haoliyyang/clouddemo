package com.cloud.contactmanger.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author haoliuyang
 */
@Builder
@Getter
@AllArgsConstructor
@TableName("tb_contact")
public final class TbContact {

    /**
     * 主键id
     */
    @TableId(type = IdType.AUTO)
     private final Integer id;
    /**
     * 类型
     */
    private final String type;
    /**
     * 信息
     */
    private final String info;
    /**
     * userId关联tbuser表
     */
    private final Integer userId;
}

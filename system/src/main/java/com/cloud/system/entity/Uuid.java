package com.cloud.system.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author haoliuyang
 */
@Getter
@Builder
@AllArgsConstructor
@TableName("uuid")
public final class Uuid {
    /**
     * 主键id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private final Integer id;
    /**
     * uuid
     */
    private final String uuid;
}

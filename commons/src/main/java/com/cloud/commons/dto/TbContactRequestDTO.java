package com.cloud.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author haoliuyang
 */
@Getter
@ToString
@AllArgsConstructor
@Builder
public final class TbContactRequestDTO {
    /**
     * 主键id
     */
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

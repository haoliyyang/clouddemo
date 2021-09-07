package com.cloud.commons.util;

import java.util.UUID;

/**
 * @author haoliuyang
 */
public class UuidUtil {

    /**
     * 生成uuid
     * @return 返回类型String
     */
    public static String getUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","");
    }
}

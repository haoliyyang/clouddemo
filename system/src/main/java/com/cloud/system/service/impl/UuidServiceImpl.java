package com.cloud.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cloud.system.entity.Uuid;
import com.cloud.system.mapper.UuidMapper;
import com.cloud.system.service.UuidService;
import org.springframework.stereotype.Service;

/**
 * @author haoliuyang
 */
@Service
public class UuidServiceImpl extends ServiceImpl<UuidMapper, Uuid> implements UuidService {
}

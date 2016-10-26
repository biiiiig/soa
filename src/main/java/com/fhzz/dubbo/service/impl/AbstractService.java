/**
 * Project: dubbo.registry.server-1.1.0-SNAPSHOT
 * 
 * File Created at 2010-6-28
 * 
 * Copyright 1999-2010 Alibaba.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alibaba Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alibaba.com.
 */
package com.fhzz.dubbo.service.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.registry.RegistryService;
import com.fhzz.dubbo.sync.RegistryServerSync;

/**
 * IbatisDAO
 * 
 * @author william.liangf
 */
@Service
public class AbstractService {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractService.class);

    @Autowired
    private RegistryServerSync           sync;
    
    @Reference
    protected RegistryService registryService;
    
    public RegistryService getRegistryService() {
		return registryService;
	}

	public ConcurrentMap<String, ConcurrentMap<String, Map<Long, URL>>> getRegistryCache(){
        return sync.getRegistryCache();
    }
    
    
}

/**
 * Copyright (c) 2023 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.log4j2;

import com.truthbean.Logger;
import com.truthbean.LoggerFactory;
import org.apache.logging.log4j.message.MessageFactory;
import org.apache.logging.log4j.spi.ExtendedLogger;
import org.apache.logging.log4j.spi.LoggerContext;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-06 23:20
 */
public class TruthBeanLoggerContext implements LoggerContext {

    private static final String EXTERNAL_CONTEXT_KEY = "__EXTERNAL_CONTEXT_KEY__";
    private final ConcurrentMap<String, Object> externalMap = new ConcurrentHashMap<>();

    @Override
    public Object getExternalContext() {
        return externalMap.get(EXTERNAL_CONTEXT_KEY);
    }

    @Override
    public Object getObject(String key) {
        return externalMap.get(key);
    }

    @Override
    public Object putObject(String key, Object value) {
        return externalMap.put(key, value);
    }

    @Override
    public Object putObjectIfAbsent(String key, Object value) {
        return externalMap.putIfAbsent(key, value);
    }

    @Override
    public Object removeObject(String key) {
        return externalMap.remove(key);
    }

    @Override
    public boolean removeObject(String key, Object value) {
        return externalMap.remove(key, value);
    }

    @Override
    public ExtendedLogger getLogger(String name) {
        Logger logger = LoggerFactory.getLogger(name);
        return new TruthBeanLogger(logger);
    }

    @Override
    public ExtendedLogger getLogger(Class<?> cls) {
        Logger logger = LoggerFactory.getLogger(cls);
        return new TruthBeanLogger(logger);
    }

    @Override
    public ExtendedLogger getLogger(String name, MessageFactory messageFactory) {
        Logger logger = LoggerFactory.getLogger(name);
        return new TruthBeanLogger(logger);
    }

    @Override
    public ExtendedLogger getLogger(Class<?> cls, MessageFactory messageFactory) {
        Logger logger = LoggerFactory.getLogger(cls);
        return new TruthBeanLogger(logger);
    }

    @Override
    public boolean hasLogger(String name) {
        return false;
    }

    @Override
    public boolean hasLogger(String name, MessageFactory messageFactory) {
        return false;
    }

    @Override
    public boolean hasLogger(String name, Class<? extends MessageFactory> messageFactoryClass) {
        return false;
    }
}

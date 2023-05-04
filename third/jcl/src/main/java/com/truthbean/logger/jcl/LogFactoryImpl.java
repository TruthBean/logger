/**
 * Copyright (c) 2023 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.jcl;

import com.truthbean.Logger;
import com.truthbean.LoggerFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-03 10:56
 */
public class LogFactoryImpl extends LogFactory {
    private volatile static LogFactoryImpl instance;

    private final Map<String, Object> attributes = new HashMap<>();

    public LogFactoryImpl() {
    }

    public static LogFactoryImpl getInstance() {
        if (instance == null) {
            synchronized (LogFactoryImpl.class) {
                if (instance == null) {
                    instance = new LogFactoryImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public Object getAttribute(String name) {
        return attributes.get(name);
    }

    @Override
    public String[] getAttributeNames() {
        return attributes.keySet().toArray(new String[0]);
    }

    @Override
    public Log getInstance(Class<?> clazz) {
        Logger logger = LoggerFactory.getLogger(clazz);
        return new JclLogger(logger);
    }

    @Override
    public Log getInstance(String name) {
        Logger logger = LoggerFactory.getLogger(name);
        return new JclLogger(logger);
    }

    @Override
    public void release() {
        attributes.clear();
    }

    @Override
    public void removeAttribute(String name) {
        attributes.remove(name);
    }

    @Override
    public void setAttribute(String name, Object value) {
        attributes.put(name, value);
    }
}

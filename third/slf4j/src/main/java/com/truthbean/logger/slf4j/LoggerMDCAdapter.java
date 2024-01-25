/**
 * Copyright (c) 2024 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.slf4j;

import org.slf4j.spi.MDCAdapter;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-06 01:48
 */
public class LoggerMDCAdapter implements MDCAdapter {
    private static final ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

    @Override
    public void put(String key, String val) {
        map.put(key, val);
    }

    @Override
    public String get(String key) {
        return map.get(key);
    }

    @Override
    public void remove(String key) {
        map.remove(key);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Map<String, String> getCopyOfContextMap() {
        return new HashMap<>(map);
    }

    @Override
    public void setContextMap(Map<String, String> contextMap) {
        map.putAll(contextMap);
    }

    @Override
    public void pushByKey(String key, String value) {
        map.put(key, value);
    }

    @Override
    public String popByKey(String key) {
        return map.remove(key);
    }

    @Override
    public Deque<String> getCopyOfDequeByKey(String key) {
        return null;
    }

    @Override
    public void clearDequeByKey(String key) {

    }
}

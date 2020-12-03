/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger;

import java.util.Optional;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-11-17 14:28
 */
public enum LogLevel {
    /**
     * 关闭所有日志
     */
    OFF,
    /**
     * 导致系统崩溃无法运行的错误
     */
    FATAL,

    /**
     * 导致数据错误或者丢失，但是系统依然能运行
     */
    ERROR,

    /**
     * 能容忍但是必须被记录下来的错误
     */
    WARN,

    /**
     * 在正常情况下需要被记录的重要信息
     */
    INFO,

    /**
     * 用于记录方便开发者排查错误及潜在隐患的信息
     */
    DEBUG,

    /**
     * 用于跟踪数据的变化
     */
    TRACE;

    public static Optional<LogLevel> of(String level) {
        var values = values();
        for (var value : values) {
            if (value.name().equalsIgnoreCase(level)) {
                return Optional.of(value);
            }
        }
        return Optional.empty();
    }
}

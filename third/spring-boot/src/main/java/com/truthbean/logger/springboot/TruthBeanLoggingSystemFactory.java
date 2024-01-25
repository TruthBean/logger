/**
 * Copyright (c) 2024 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.springboot;

import org.springframework.boot.logging.LoggingSystem;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author TruthBean
 * @since 0.5.4
 * Created on 2022/01/04 20:26.
 */
@Order(Ordered.LOWEST_PRECEDENCE)
public class TruthBeanLoggingSystemFactory implements org.springframework.boot.logging.LoggingSystemFactory {
    @Override
    public LoggingSystem getLoggingSystem(ClassLoader classLoader) {
        return new TruthBeanLoggerSystem(classLoader);
    }
}

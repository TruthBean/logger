/**
 * Copyright (c) 2023 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.springboot;

import com.truthbean.LoggerFactory;
import com.truthbean.logger.LogLevel;
import org.springframework.boot.BootstrapRegistry;
import org.springframework.boot.BootstrapRegistryInitializer;
import org.springframework.boot.logging.LoggingSystem;

/**
 * @author TruthBean
 * @since 0.5.4
 * Created on 2022/01/04 20:05.
 */
public class TruthBeanLoggerBootstrapRegistryInitializer implements BootstrapRegistryInitializer {

    static {
        System.setProperty(LoggingSystem.SYSTEM_PROPERTY, TruthBeanLoggerSystem.class.getName());
        LoggerFactory.getConfig().setLogLevel("root", LogLevel.INFO);
        LoggerFactory.getConfig().setLogLevel("com.truthbean", LogLevel.INFO);
    }

    @Override
    public void initialize(BootstrapRegistry registry) {
    }
}

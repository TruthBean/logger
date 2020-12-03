/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.springboot;

import com.truthbean.logger.LogLevel;
import com.truthbean.logger.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.ConfigurationWarningsApplicationContextInitializer;
import org.springframework.boot.logging.LoggingSystem;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.util.Map;
import java.util.Set;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-03 14:50
 */
public class TruthBeanLoggerInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    static {
        System.setProperty(LoggingSystem.SYSTEM_PROPERTY, TruthBeanLoggerSystem.class.getName());
        LoggerFactory.getConfig().setLogLevel("root", LogLevel.INFO);
        LoggerFactory.getConfig().setLogLevel("org.apache.catalina.startup.DigesterFactory", LogLevel.ERROR);
        LoggerFactory.getConfig().setLogLevel("org.apache.catalina.util.LifecycleBase", LogLevel.ERROR);
        LoggerFactory.getConfig().setLogLevel("org.apache.coyote.http11.Http11NioProtocol", LogLevel.WARN);
        LoggerFactory.getConfig().setLogLevel("org.apache.sshd.common.util.SecurityUtils", LogLevel.WARN);
        LoggerFactory.getConfig().setLogLevel("org.apache.tomcat.util.net.NioSelectorPool", LogLevel.WARN);
        LoggerFactory.getConfig().setLogLevel("org.eclipse.jetty.util.component.AbstractLifeCycle", LogLevel.ERROR);
        LoggerFactory.getConfig().setLogLevel("org.hibernate.validator.internal.util.Version", LogLevel.WARN);
        LoggerFactory.getConfig().setLogLevel("org.springframework.boot.actuate.endpoint.jmx", LogLevel.WARN);
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        // do nothing
    }
}

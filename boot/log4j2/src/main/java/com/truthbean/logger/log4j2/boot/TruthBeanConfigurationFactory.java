/**
 * Copyright (c) 2022 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.log4j2.boot;

import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.*;
import org.apache.logging.log4j.core.config.plugins.Plugin;

import static org.apache.logging.log4j.core.config.DefaultConfiguration.DEFAULT_LEVEL;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.2.0
 * Created on 2020-08-31 14:57
 */
@Plugin(name = "TruthBeanConfigurationFactory", category = ConfigurationFactory.CATEGORY)
@Order(0)
public class TruthBeanConfigurationFactory extends ConfigurationFactory {
    private static final String[] TYPES = { ".truthbean" };

    public TruthBeanConfigurationFactory() {
    }

    @Override
    protected String[] getSupportedTypes() {
        return TYPES;
    }

    @Override
    public Configuration getConfiguration(LoggerContext loggerContext, ConfigurationSource source) {
        if (source != null && source != ConfigurationSource.NULL_SOURCE) {
            System.setProperty(DEFAULT_LEVEL, "INFO");
            return new TruthBeanConfiguration();
        }
        return null;
    }

    private static final class TruthBeanConfiguration extends DefaultConfiguration {

        private TruthBeanConfiguration() {
            super();
            this.isShutdownHookEnabled = false;
        }

    }

}

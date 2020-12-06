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

import com.truthbean.logger.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-02 17:10
 */
@Component
@ConfigurationProperties(prefix = "com.truthbean.logger")
public class TruthBeanLoggerProperties {

    public TruthBeanLoggerProperties() {
    }

    private boolean no;

    private boolean systemOut;

    public boolean isNo() {
        return no;
    }

    public void setNo(boolean no) {
        this.no = no;
        System.setProperty(LoggerFactory.NO_LOGGER, String.valueOf(no));
    }

    public boolean getSystemOut() {
        return systemOut;
    }

    public void setSystemOut(boolean systemOut) {
        this.systemOut = systemOut;
        System.setProperty(LoggerFactory.STD_OUT, String.valueOf(no));
    }
}

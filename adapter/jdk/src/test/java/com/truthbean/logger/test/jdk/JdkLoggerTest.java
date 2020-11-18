/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.test.jdk;

import com.truthbean.Logger;
import com.truthbean.logger.LoggerFactory;
import org.junit.jupiter.api.Test;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-11-18 11:56
 */
public class JdkLoggerTest {

    static {
        System.setProperty("logging.level.com.truthbean.logger.test.jdk", "TRACE");
    }

    @Test
    void trace() {
        logger.trace((String) null);
        logger.trace("trace", (Object) null);
        logger.trace("trace {} 1", (Object) null);
        logger.trace("trace {} 1", (Throwable) null);
        logger.trace("trace {} 1", null, null, null);
        logger.trace("trace");

        var logger = java.lang.System.getLogger(JdkLoggerTest.class.getName());
        System.out.println(logger);
        logger.log(System.Logger.Level.TRACE, "trace");
        logger.log(System.Logger.Level.DEBUG, "debug");
        logger.log(System.Logger.Level.INFO, "info");
        logger.log(System.Logger.Level.WARNING, "warn");
        logger.log(System.Logger.Level.ERROR, "error");
    }

    private static final Logger logger = LoggerFactory.getLogger(JdkLoggerTest.class);
}

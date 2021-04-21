/**
 * Copyright (c) 2021 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.log4j2.test;

import com.truthbean.logger.LogLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-06 23:02
 */
public class Log4j2ImplTest {

    static {
        com.truthbean.LoggerFactory.getConfig().setLogLevel(Log4j2ImplTest.class.getName(), LogLevel.TRACE);
    }

    @Test
    public void test() {
        Logger logger = LogManager.getLogger(Log4j2ImplTest.class);
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.error("error");
        logger.fatal("fatal");
    }
}

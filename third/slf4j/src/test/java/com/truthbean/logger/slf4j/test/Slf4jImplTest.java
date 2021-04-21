/**
 * Copyright (c) 2021 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.slf4j.test;

import com.truthbean.logger.LogLevel;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-06 22:32
 */
public class Slf4jImplTest {

    static {
        // com.truthbean.LoggerFactory.getConfig().setLogLevel(Slf4jImplTest.class.getName(), LogLevel.TRACE);
    }

    @Test
    public void test() {
        Logger logger = LoggerFactory.getLogger(Slf4jImplTest.class);
        logger.trace("test");
        logger.debug("test");
        logger.info("test");
        logger.warn("test");
        logger.error("test");
    }
}

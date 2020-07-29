/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.kotlin.check

import com.truthbean.logger.kt.Logging
import org.junit.jupiter.api.Test


/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:32
 */
class LoggingTest: Logging {
    private val service = TestService(logger)

    @Test
    fun testInfo() {
        logger.info { "message" }
        logger.info("msg{},{}", 1, "444")
        service.info()
    }

    @Test
    fun testDebug() {
        logger.debug("debug")
        logger.debug("debug{},{},{}", 55, "7777", this)
        service.debug()
    }

    @Test
    fun testError() {
        logger.error("66666666", RuntimeException("7777"))
        service.error()
    }

    @Test
    fun testTrace() {
        logger.trace("trace")
        logger.trace { "hello trace" }
        logger.trace({ "hello trace" }, RuntimeException())
        service.trace()
    }

    override fun toString(): String {
        return "888888888888888888888888"
    }
}
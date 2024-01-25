/**
 * Copyright (c) 2024 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.slf4j.check;

import com.truthbean.Logger;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-13 11:27.
 */
public class TestService {
    private final Logger logger;
    public TestService(Logger logger) {
        this.logger = logger;
    }

    public void trace() {
        logger.trace("1. message");
        logger.trace(() -> "2. message");
        logger.trace("3. message", new RuntimeException());
        logger.trace("{}. {}", 4, "message");
        logger.trace(() -> "5. message", new RuntimeException());
        logger.trace("{}. {}", new RuntimeException(), 4, "message");
    }

    public void debug() {
        logger.debug("1. message");
        logger.debug(() -> "2. message");
        logger.debug("3. message", new RuntimeException());
        logger.debug("{}. {}", 4, "message");
        logger.debug(() -> "5. message", new RuntimeException());
        logger.debug("{}. {}", new RuntimeException(), 4, "message");
    }

    public void info() {
        logger.info("1. message");
        logger.info(() -> "2. message");
        logger.info("3. message", new RuntimeException());
        logger.info("{}. {}", 4, "message");
        logger.info(() -> "5. message", new RuntimeException());
        logger.info("{}. {}", new RuntimeException(), 4, "message");
    }

    public void warn() {
        logger.warn("1. message");
        logger.warn(() -> "2. message");
        logger.warn("3. message", new RuntimeException());
        logger.warn("{}. {}", 4, "message");
        logger.warn(() -> "5. message", new RuntimeException());
        logger.warn("{}. {}", new RuntimeException(), 4, "message");
    }

    public void error() {
        logger.error("1. message");
        logger.error(() -> "2. message");
        logger.error("3. message", new RuntimeException());
        logger.error("{}. {}", 4, "message");
        logger.error(() -> "5. message", new RuntimeException());
        logger.error("{}. {}", new RuntimeException(), 4, "message");
    }

    public void fatal() {
        logger.fatal("1. message");
        logger.fatal(() -> "2. message");
        logger.fatal("3. message", new RuntimeException());
        logger.fatal("{}. {}", 4, "message");
        logger.fatal(() -> "5. message", new RuntimeException());
        logger.fatal("{}. {}", new RuntimeException(), 4, "message");
    }
}

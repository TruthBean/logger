/**
 * Copyright (c) 2021 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.juli;

import com.truthbean.Logger;
import com.truthbean.LoggerFactory;
import org.apache.juli.logging.Log;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-11-30 11:19
 */
public class JuliLogger implements Log {

    private Logger logger;

    public JuliLogger() {
    }

    @SuppressWarnings("unused")
    public JuliLogger(String name) {
        logger = LoggerFactory.getLogger(name);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    @Override
    public boolean isFatalEnabled() {
        return logger.isFatalEnabled();
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    @Override
    public void trace(Object message) {
        if (logger.isTraceEnabled()) {
            logger.trace(message);
        }
    }

    @Override
    public void trace(Object message, Throwable t) {
        if (logger.isTraceEnabled()) {
            logger.trace(message, t);
        }
    }

    @Override
    public void debug(Object message) {
        if (logger.isDebugEnabled()) {
            logger.debug(message);
        }
    }

    @Override
    public void debug(Object message, Throwable t) {
        if (logger.isDebugEnabled()) {
            logger.debug(message, t);
        }
    }

    @Override
    public void info(Object message) {
        if (logger.isInfoEnabled()) {
            logger.info(message);
        }
    }

    @Override
    public void info(Object message, Throwable t) {
        if (logger.isInfoEnabled()) {
            logger.info(message, t);
        }
    }

    @Override
    public void warn(Object message) {
        if (logger.isWarnEnabled()) {
            logger.warn(message);
        }
    }

    @Override
    public void warn(Object message, Throwable t) {
        if (logger.isWarnEnabled()) {
            logger.warn(message, t);
        }
    }

    @Override
    public void error(Object message) {
        if (logger.isErrorEnabled()) {
            logger.error(message);
        }
    }

    @Override
    public void error(Object message, Throwable t) {
        if (logger.isErrorEnabled()) {
            logger.error(message, t);
        }
    }

    @Override
    public void fatal(Object message) {
        if (logger.isFatalEnabled()) {
            logger.fatal(message);
        }
    }

    @Override
    public void fatal(Object message, Throwable t) {
        if (logger.isFatalEnabled()) {
            logger.fatal(message, t);
        }
    }
}

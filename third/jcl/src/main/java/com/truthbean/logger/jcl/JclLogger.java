/**
 * Copyright (c) 2022 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.jcl;

import com.truthbean.Logger;
import com.truthbean.logger.LogLevel;
import org.apache.commons.logging.Log;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-03 10:38
 */
public class JclLogger implements Log {
    private final Logger logger;
    public JclLogger(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void debug(Object message) {
        logger.log(LogLevel.DEBUG, message, null, (Object[]) null);
    }

    @Override
    public void debug(Object message, Throwable t) {
        logger.log(LogLevel.DEBUG, message, t, (Object[]) null);
    }

    @Override
    public void error(Object message) {
        logger.log(LogLevel.ERROR, message, null, (Object[]) null);
    }

    @Override
    public void error(Object message, Throwable t) {
        logger.log(LogLevel.ERROR, message, t, (Object[]) null);
    }

    @Override
    public void fatal(Object message) {
        logger.log(LogLevel.FATAL, message, null, (Object[]) null);
    }

    @Override
    public void fatal(Object message, Throwable t) {
        logger.log(LogLevel.FATAL, message, t, (Object[]) null);
    }

    @Override
    public void info(Object message) {
        logger.log(LogLevel.INFO, message, null, (Object[]) null);
    }

    @Override
    public void info(Object message, Throwable t) {
        logger.log(LogLevel.INFO, message, t, (Object[]) null);
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
        logger.log(LogLevel.TRACE, message, null, (Object[]) null);
    }

    @Override
    public void trace(Object message, Throwable t) {
        logger.log(LogLevel.TRACE, message, t, (Object[]) null);
    }

    @Override
    public void warn(Object message) {
        logger.log(LogLevel.WARN, message, null, (Object[]) null);
    }

    @Override
    public void warn(Object message, Throwable t) {
        logger.log(LogLevel.TRACE, message, t, (Object[]) null);
    }
}

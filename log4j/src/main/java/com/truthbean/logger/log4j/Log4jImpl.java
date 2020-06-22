/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.log4j;

import com.truthbean.logger.util.MessageHelper;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.function.Supplier;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-10 22:12
 */
public class Log4jImpl implements com.truthbean.Logger {
    private Logger logger;
    private static final String FQCN = Log4jImpl.class.getName();

    @Override
    public com.truthbean.Logger setName(String name) {
        this.logger = LogManager.getLogger(name);
        return this;
    }

    @Override
    public com.truthbean.Logger setClass(Class<?> tracedClass) {
        this.logger = LogManager.getLogger(tracedClass);
        return this;
    }

    @Override
    public boolean isTraceEnabled() {
        return this.logger.isTraceEnabled();
    }

    @Override
    public void trace(String message) {
        if (this.logger.isTraceEnabled()) {
            this.logger.log(FQCN, Level.TRACE, message, null);
        }
    }

    @Override
    public void trace(Supplier<String> supplier) {
        if (this.logger.isTraceEnabled()) {
            this.logger.log(FQCN, Level.TRACE, supplier.get(), null);
        }
    }

    @Override
    public void trace(String message, Object... params) {
        if (this.logger.isTraceEnabled()) {
            message = MessageHelper.format(message, params);
            this.logger.log(FQCN, Level.TRACE, message, null);
        }
    }

    @Override
    public void trace(String message, Throwable e) {
        if (this.logger.isTraceEnabled()) {
            this.logger.log(FQCN, Level.TRACE, message, e);
        }
    }

    @Override
    public void trace(Supplier<String> supplier, Throwable e) {
        if (this.logger.isTraceEnabled()) {
            this.logger.log(FQCN, Level.TRACE, supplier.get(), e);
        }
    }

    @Override
    public void trace(String message, Throwable e, Object... params) {
        if (this.logger.isTraceEnabled()) {
            message = MessageHelper.format(message, params);
            this.logger.log(FQCN, Level.TRACE, message, e);
        }
    }

    @Override
    public boolean isDebugEnabled() {
        return this.logger.isDebugEnabled();
    }

    @Override
    public void debug(String message) {
        if (this.logger.isDebugEnabled()) {
            this.logger.log(FQCN, Level.DEBUG, message, null);
        }
    }

    @Override
    public void debug(Supplier<String> supplier) {
        if (this.logger.isDebugEnabled()) {
            this.logger.log(FQCN, Level.DEBUG, supplier.get(), null);
        }
    }

    @Override
    public void debug(String message, Object... params) {
        if (this.logger.isDebugEnabled()) {
            message = MessageHelper.format(message, params);
            this.logger.log(FQCN, Level.DEBUG, message, null);
        }
    }

    @Override
    public void debug(String message, Throwable e) {
        if (this.logger.isDebugEnabled()) {
            this.logger.log(FQCN, Level.DEBUG, message, e);
        }
    }

    @Override
    public void debug(Supplier<String> supplier, Throwable e) {
        if (this.logger.isDebugEnabled()) {
            this.logger.log(FQCN, Level.DEBUG, supplier.get(), e);
        }
    }

    @Override
    public void debug(String message, Throwable e, Object... params) {
        if (this.logger.isDebugEnabled()) {
            message = MessageHelper.format(message, params);
            this.logger.log(FQCN, Level.DEBUG, message, e);
        }
    }

    @Override
    public boolean isInfoEnabled() {
        return this.logger.isInfoEnabled();
    }

    @Override
    public void info(String message) {
        if (this.logger.isInfoEnabled()) {
            this.logger.log(FQCN, Level.INFO, message, null);
        }
    }

    @Override
    public void info(Supplier<String> supplier) {
        if (this.logger.isInfoEnabled()) {
            this.logger.log(FQCN, Level.INFO, supplier.get(), null);
        }
    }

    @Override
    public void info(String message, Object... params) {
        if (this.logger.isInfoEnabled()) {
            message = MessageHelper.format(message, params);
            this.logger.log(FQCN, Level.INFO, message, null);
        }
    }

    @Override
    public void info(String message, Throwable e) {
        if (this.logger.isInfoEnabled()) {
            this.logger.log(FQCN, Level.INFO, message, e);
        }
    }

    @Override
    public void info(Supplier<String> supplier, Throwable e) {
        if (this.logger.isInfoEnabled()) {
            this.logger.log(FQCN, Level.INFO, supplier.get(), e);
        }
    }

    @Override
    public void info(String message, Throwable e, Object... params) {
        if (this.logger.isInfoEnabled()) {
            message = MessageHelper.format(message, params);
            this.logger.log(FQCN, Level.INFO, message, e);
        }
    }

    @Override
    public boolean isWarnEnabled() {
        return this.logger.isEnabledFor(Level.WARN);
    }

    @Override
    public void warn(String message) {
        if (this.logger.isEnabledFor(Level.WARN)) {
            this.logger.log(FQCN, Level.WARN, message, null);
        }
    }

    @Override
    public void warn(Supplier<String> supplier) {
        if (this.logger.isEnabledFor(Level.WARN)) {
            this.logger.log(FQCN, Level.WARN, supplier.get(), null);
        }
    }

    @Override
    public void warn(String message, Object... params) {
        if (this.logger.isEnabledFor(Level.WARN)) {
            message = MessageHelper.format(message, params);
            this.logger.log(FQCN, Level.WARN, message, null);
        }
    }

    @Override
    public void warn(String message, Throwable e) {
        if (this.logger.isEnabledFor(Level.WARN)) {
            this.logger.log(FQCN, Level.WARN, message, e);
        }
    }

    @Override
    public void warn(Supplier<String> supplier, Throwable e) {
        if (this.logger.isEnabledFor(Level.WARN)) {
            this.logger.log(FQCN, Level.WARN, supplier.get(), e);
        }
    }

    @Override
    public void warn(String message, Throwable e, Object... params) {
        if (this.logger.isEnabledFor(Level.WARN)) {
            message = MessageHelper.format(message, params);
            this.logger.log(FQCN, Level.WARN, message, e);
        }
    }

    @Override
    public boolean isErrorEnabled() {
        return this.logger.isEnabledFor(Level.ERROR);
    }

    @Override
    public void error(String message) {
        if (this.logger.isEnabledFor(Level.ERROR)) {
            this.logger.log(FQCN, Level.ERROR, message, null);
        }
    }

    @Override
    public void error(Supplier<String> supplier) {
        if (this.logger.isEnabledFor(Level.ERROR)) {
            this.logger.log(FQCN, Level.ERROR, supplier.get(), null);
        }
    }

    @Override
    public void error(String message, Object... params) {
        if (this.logger.isEnabledFor(Level.ERROR)) {
            message = MessageHelper.format(message, params);
            this.logger.log(FQCN, Level.ERROR, message, null);
        }
    }

    @Override
    public void error(String message, Throwable e) {
        if (this.logger.isEnabledFor(Level.ERROR)) {
            this.logger.log(FQCN, Level.ERROR, message, e);
        }
    }

    @Override
    public void error(Supplier<String> supplier, Throwable e) {
        if (this.logger.isEnabledFor(Level.ERROR)) {
            this.logger.log(FQCN, Level.INFO, supplier.get(), e);
        }
    }

    @Override
    public void error(String message, Throwable e, Object... params) {
        if (this.logger.isEnabledFor(Level.ERROR)) {
            message = MessageHelper.format(message, params);
            this.logger.log(FQCN, Level.ERROR, message, e);
        }
    }

    @Override
    public boolean isFatalEnabled() {
        return this.logger.isEnabledFor(Level.FATAL);
    }

    @Override
    public void fatal(String message) {
        if (this.logger.isEnabledFor(Level.FATAL)) {
            this.logger.log(FQCN, Level.FATAL, message, null);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier) {
        if (this.logger.isEnabledFor(Level.FATAL)) {
            this.logger.log(FQCN, Level.FATAL, supplier.get(), null);
        }
    }

    @Override
    public void fatal(String message, Object... params) {
        if (this.logger.isEnabledFor(Level.FATAL)) {
            message = MessageHelper.format(message, params);
            this.logger.log(FQCN, Level.FATAL, message, null);
        }
    }

    @Override
    public void fatal(String message, Throwable e) {
        if (this.logger.isEnabledFor(Level.FATAL)) {
            this.logger.log(FQCN, Level.FATAL, message, e);
        }
    }

    @Override
    public void fatal(Supplier<String> supplier, Throwable e) {
        if (this.logger.isEnabledFor(Level.FATAL)) {
            this.logger.log(FQCN, Level.FATAL, supplier.get(), e);
        }
    }

    @Override
    public void fatal(String message, Throwable e, Object... params) {
        if (this.logger.isEnabledFor(Level.FATAL)) {
            message = MessageHelper.format(message, params);
            this.logger.log(FQCN, Level.FATAL, message, e);
        }
    }
}

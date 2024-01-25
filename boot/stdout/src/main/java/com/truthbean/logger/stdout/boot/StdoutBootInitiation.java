/**
 * Copyright (c) 2024 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.stdout.boot;

import com.truthbean.logger.LoggerInitiation;
import com.truthbean.logger.jul.bridge.JulBridgeLoggerHandler;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-09 18:21
 */
public class StdoutBootInitiation implements LoggerInitiation {
    @Override
    public void init() {
        JulBridgeLoggerHandler.install();
    }

    @Override
    public void flush() {
    }

    @Override
    public void destroy() {
        JulBridgeLoggerHandler.uninstall();
    }
}

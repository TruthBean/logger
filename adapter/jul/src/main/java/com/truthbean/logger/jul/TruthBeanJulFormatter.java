/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.jul;

import com.truthbean.logger.util.MessageHelper;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.3.1
 * Created on 2020-11-17 13:50
 */
public class TruthBeanJulFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        var level = record.getLevel();
        var cname = record.getSourceClassName();
        var method = record.getSourceMethodName();

        var location = cname + "." + method + "()";

        var threadName = Thread.currentThread().getName();
        var logger = MessageHelper.buildMessage(level.getName(), threadName, location);
        var newMessage = record.getMessage() + "\033[0m";
        logger.append(newMessage).append("\n");
        return logger.toString();
    }
}

/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.util;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 22:03
 */
public class MessageHelper {
    private MessageHelper() {
    }

    public static String format(String message, Object...params) {
        if (params == null || params.length == 0) {
            return message;
        }
        var splits = message.split("\\{}");
        var result = new StringBuilder(splits[0]);
        result.append(params[0]);
        if (splits.length > 1) {
            var min = Math.min(splits.length, params.length);
            for (int i = 1; i < min; i++) {
                result.append(splits[i]).append(params[i]);
            }
            if (splits.length > params.length) {
                for (int i = params.length; i < splits.length; i++) {
                    result.append(splits[i]);
                }
            }
        }
        return result.toString();
    }

    public static String toString(Object message) {
        if (message == null) {
            return "null";
        }
        return message.toString();
    }
}

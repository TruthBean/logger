/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.jdk;

import java.util.logging.Level;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-02-13 13:29
 */
class JdkLevel extends Level {
    protected JdkLevel(String name, int value) {
        super(name, value);
    }

    JdkLevel(String name, int value, String resourceBundleName) {
        super(name, value, resourceBundleName);
    }

    private static final String defaultBundle = "sun.util.logging.resources.logging";

    public static final Level FATAL = new JdkLevel("FATAL", 1100, defaultBundle);
    public static final Level DEBUG = new JdkLevel("DEBUG", 600, defaultBundle);
    public static final Level TRACE = new JdkLevel("TRACE", 500, defaultBundle);
}

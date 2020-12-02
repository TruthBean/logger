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

import java.util.logging.Level;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-02-13 13:29
 */
public class JulLevel extends Level {
    /**
     * serial version
     */
    private static final long serialVersionUID = -4242942266318231264L;

    protected JulLevel(String name, int value) {
        super(name, value);
    }

    JulLevel(String name, int value, String resourceBundleName) {
        super(name, value, resourceBundleName);
    }

    private static final String DEFAULT_BUNDLE = "sun.util.logging.resources.logging";

    public static final Level FATAL = Level.OFF;
    public static final Level ERROR = Level.SEVERE;
    public static final Level WARN = Level.WARNING;
    public static final Level INFO = Level.INFO;
    public static final Level DEBUG = Level.FINE;
    public static final Level TRACE = Level.FINER;
}

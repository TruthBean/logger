/**
 * Copyright (c) 2022 TruthBean(Rogar·Q)
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
 * @since 0.5.1
 * Created on 2021-06-05 12:07
 */
public class ColorHelper {
    public static final int BOLD = 1;

    public static final int ITALIC = 3;

    public static final int UNDERSCORE = 21;

    public static final int BACKGROUND_WHITE = 7;

    public static final int DELETE = 9;

    public static final int BACKGROUND_BLACK = 40;

    public static final int BACKGROUND_RED = 41;

    public static final int BACKGROUND_GREEN = 42;

    public static final int BACKGROUND_YELLOW = 43;

    public static final int BACKGROUND_BLUE = 44;

    public static final int BACKGROUND_PINK = 45;

    public static final int BACKGROUND_CYANBLUE = 46;

    public static final int BACKGROUND_GRAY = 47;

    public static final int BLOCK = 52;

    public static final int[] STYLES = new int[]{
            BOLD, ITALIC, UNDERSCORE, BACKGROUND_WHITE, DELETE,
            BACKGROUND_BLACK, BACKGROUND_RED, BACKGROUND_GREEN, BACKGROUND_YELLOW, BACKGROUND_BLUE, BACKGROUND_PINK,
            BACKGROUND_CYANBLUE, BACKGROUND_GRAY,
            BLOCK
    };

    public static final int WHITE = 97;

    public static final int CYANBLUE = 96;

    public static final int PINK = 95;

    public static final int BLUE = 94;

    public static final int YELLOW = 93;

    public static final int GREEN = 92;

    public static final int RED = 91;

    public static final int BLACK = 30;

    public static final int GRAY = 90;

    public static final int[] COLORS = new int[]{
            WHITE, CYANBLUE, PINK, BLUE, YELLOW, GREEN, RED, BLACK, GRAY
    };

}

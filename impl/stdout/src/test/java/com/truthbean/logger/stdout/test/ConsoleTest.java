/**
 * Copyright (c) 2023 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.stdout.test;

import com.truthbean.Console;
import com.truthbean.logger.util.ColorHelper;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.5.1
 * Created on 2021-06-05 15:23
 */
public class ConsoleTest {
    public static void main(String[] args) {
        Console.fatal("message");
        Console.error("message");
        Console.warn("message");
        Console.info("message");
        Console.debug("message");
        Console.trace("message");

        Console.f("ConsoleTest", "message");
        Console.e("ConsoleTest", "message");
        Console.w("ConsoleTest", "message");
        Console.i("ConsoleTest", "message");
        Console.d("ConsoleTest", "message");
        Console.t("ConsoleTest", "message");

        Console.write(ColorHelper.YELLOW, ColorHelper.DELETE, "黄色 ");
        Console.writeLine(ColorHelper.WHITE, ColorHelper.BACKGROUND_GREEN, "不，我要绿色");
    }
}

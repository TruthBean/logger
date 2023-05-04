/**
 * Copyright (c) 2023 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.springboot;

import com.truthbean.Console;
import com.truthbean.logger.util.ColorHelper;
import org.springframework.boot.ExitCodeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;

/**
 * @author TruthBean
 * @since 0.5.4
 * Created on 2022/02/10 14:21.
 */
public class ExitCodeEventListener implements ApplicationListener<ExitCodeEvent> {

    @Override
    public void onApplicationEvent(@NonNull ExitCodeEvent event) {
        Console.writeLine(ColorHelper.WHITE, ColorHelper.BACKGROUND_GREEN, "System exit(" + event.getExitCode() + ")");
    }
}

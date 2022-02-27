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

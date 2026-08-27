package com.truthbean.logger.springboot;

import com.truthbean.Console;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.boot.bootstrap.ConfigurableBootstrapContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.6.2
 */
public class TruthBeanLoggerSpringApplicationRunListener implements SpringApplicationRunListener {
    @Override
    public void starting(@NonNull ConfigurableBootstrapContext bootstrapContext) {
        Console.info("Spring Boot starting");
    }

    @Override
    public void environmentPrepared(@NonNull ConfigurableBootstrapContext bootstrapContext, @NonNull ConfigurableEnvironment environment) {
        Console.info("Spring Boot environmentPrepared");
    }

    @Override
    public void contextPrepared(@NonNull ConfigurableApplicationContext context) {
        Console.info("Spring Boot contextPrepared");
    }

    @Override
    public void contextLoaded(@NonNull ConfigurableApplicationContext context) {
        Console.info("Spring Boot contextLoaded");
    }

    @Override
    public void started(@NonNull ConfigurableApplicationContext context, Duration timeTaken) {
        Console.info("Spring Boot started with time taken: " + formatDuration(timeTaken));
    }

    @Override
    public void ready(@NonNull ConfigurableApplicationContext context, Duration timeTaken) {
        Console.info("Spring Boot ready with time taken: " + formatDuration(timeTaken));
    }

    @Override
    public void failed(ConfigurableApplicationContext context, @NonNull Throwable exception) {
        Console.info("Spring Boot failed with exception: " + exception);
    }

    private String formatDuration(Duration duration) {
        return String.format("%02d:%02d:%02d.%03d", duration.toHours(), duration.toMinutesPart(), duration.toSecondsPart(), duration.toMillisPart());
    }
}

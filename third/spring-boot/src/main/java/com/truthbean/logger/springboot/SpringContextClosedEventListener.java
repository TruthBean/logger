package com.truthbean.logger.springboot;

import com.truthbean.Console;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.6.2
 */
public class SpringContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        Console.info("Spring Context Closed");
    }
}

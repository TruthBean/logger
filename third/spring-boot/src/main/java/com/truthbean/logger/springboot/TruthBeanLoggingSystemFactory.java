package com.truthbean.logger.springboot;

import org.springframework.boot.logging.LoggingSystem;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author TruthBean
 * @since 0.5.4
 * Created on 2022/01/04 20:26.
 */
@Order(Ordered.LOWEST_PRECEDENCE)
public class TruthBeanLoggingSystemFactory implements org.springframework.boot.logging.LoggingSystemFactory {
    @Override
    public LoggingSystem getLoggingSystem(ClassLoader classLoader) {
        return new TruthBeanLoggerSystem(classLoader);
    }
}

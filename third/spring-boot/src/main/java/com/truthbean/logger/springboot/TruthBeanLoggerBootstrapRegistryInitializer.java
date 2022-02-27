package com.truthbean.logger.springboot;

import com.truthbean.LoggerFactory;
import com.truthbean.logger.LogLevel;
import org.springframework.boot.BootstrapRegistry;
import org.springframework.boot.BootstrapRegistryInitializer;
import org.springframework.boot.logging.LoggingSystem;

/**
 * @author TruthBean
 * @since 0.5.4
 * Created on 2022/01/04 20:05.
 */
public class TruthBeanLoggerBootstrapRegistryInitializer implements BootstrapRegistryInitializer {

    static {
        System.setProperty(LoggingSystem.SYSTEM_PROPERTY, TruthBeanLoggerSystem.class.getName());
        LoggerFactory.getConfig().setLogLevel("root", LogLevel.INFO);
        LoggerFactory.getConfig().setLogLevel("com.truthbean", LogLevel.INFO);
    }

    @Override
    public void initialize(BootstrapRegistry registry) {
    }
}

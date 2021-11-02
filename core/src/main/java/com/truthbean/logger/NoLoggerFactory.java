package com.truthbean.logger;

import com.truthbean.Logger;

/**
 * @author TruthBean
 * @since 0.5.3
 */
public class NoLoggerFactory implements LogFactory {

    private final Logger logger = new NoLogger();

    @Override
    public Logger factory() {
        return logger;
    }
}

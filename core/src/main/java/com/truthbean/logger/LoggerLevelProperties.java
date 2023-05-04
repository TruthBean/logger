package com.truthbean.logger;

import java.util.Map;

/**
 * logging.level.
 * @author TruthBean
 * @since 0.5.5
 * Created on 2022/03/08 09:16.
 */
public class LoggerLevelProperties {
    /**
     * logging.level.root=
     */
    private LogLevel root;

    /**
     * logging.level.xxx=
     */
    private Map<String, LogLevel> levels;

    public LogLevel getRoot() {
        return root;
    }

    public void setRoot(LogLevel root) {
        this.root = root;
    }

    public Map<String, LogLevel> getLevels() {
        return levels;
    }

    public void setLevels(Map<String, LogLevel> levels) {
        this.levels = levels;
    }
}

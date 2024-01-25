/**
 * Copyright (c) 2024 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-02 17:10
 */
public class TruthBeanLoggerProperties {

    public TruthBeanLoggerProperties() {
    }

    private boolean disable;

    private boolean no;

    private boolean systemOut;

    private boolean stdoutColor;

    private boolean useName;

    private boolean locationTime;

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
        System.setProperty(LoggerConfig.DISABLE_LOGGER, String.valueOf(disable));
    }

    public boolean isNo() {
        return no;
    }

    public void setNo(boolean no) {
        this.no = no;
        System.setProperty(LoggerConfig.NO_LOGGER, String.valueOf(no));
    }

    public boolean isSystemOut() {
        return systemOut;
    }

    public void setSystemOut(boolean systemOut) {
        this.systemOut = systemOut;
        System.setProperty(LoggerConfig.STD_OUT, String.valueOf(no));
    }

    public boolean isStdoutColor() {
        return stdoutColor;
    }

    public void setStdoutColor(boolean stdoutColor) {
        this.stdoutColor = stdoutColor;
        System.setProperty(LoggerConfig.STD_OUT, String.valueOf(stdoutColor));
    }

    public boolean isUseName() {
        return useName;
    }

    public void setUseName(boolean useName) {
        this.useName = useName;
        System.setProperty(LoggerConfig.USE_NAME, String.valueOf(useName));
    }

    public boolean isLocationTime() {
        return locationTime;
    }

    public void setLocationTime(boolean locationTime) {
        System.setProperty(ConfigurableLogger.LOCATION_TIME, String.valueOf(locationTime));
        this.locationTime = locationTime;
    }
}

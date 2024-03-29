/**
 * Copyright (c) 2024 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */

/**
 * @author TruthBean/Rogar·Q
 * @since 0.1.0
 */
module com.truthbean.logger.log4j2.boot {
    exports com.truthbean.logger.log4j2.boot to org.apache.logging.log4j.core;
    requires transitive com.truthbean.logger.log4j2;
    requires transitive org.apache.logging.log4j;
    requires static org.apache.logging.log4j.core;
    requires transitive org.slf4j;
    requires transitive java.logging;
    requires static org.apache.logging.log4j.jul;
    requires static org.apache.logging.log4j.jpl;
    requires static org.apache.logging.log4j.jcl;
    requires com.truthbean.logger.core;
    // requires static com.truthbean.logger.slf4j.impl;

    provides com.truthbean.logger.LoggerInitiation with com.truthbean.logger.log4j2.boot.Log4j2BootInitiation;
    // provides System.LoggerFinder with org.apache.logging.log4j.jpl.Log4jSystemLoggerFinder;
}
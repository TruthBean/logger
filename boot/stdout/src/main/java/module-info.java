/**
 * Copyright (c) 2021 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-09 18:22
 */
module com.truthbean.logger.stdout.boot {
    requires transitive com.truthbean.logger.core;
    requires transitive com.truthbean.logger.jdk.common;
    requires transitive com.truthbean.logger.jdk9;
    requires transitive com.truthbean.logger.jcl;
    requires transitive com.truthbean.logger.slf4j.impl;
    requires transitive com.truthbean.logger.log4j2.impl;

    requires transitive com.truthbean.logger.stdout;
    requires transitive com.truthbean.logger.jul.bridge;

    requires java.logging;

    provides com.truthbean.logger.LoggerInitiation with com.truthbean.logger.stdout.boot.StdoutBootInitiation;
}
/**
 * Copyright (c) 2024 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * <a href="http://license.coscl.org.cn/MulanPSL2">http://license.coscl.org.cn/MulanPSL2</a>
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 *
 * @author TruthBean/Rogar·Q
 * @since 0.1.0
 */
open module com.truthbean.logger.log4j2.boot.test {
    requires com.truthbean.logger.log4j2.boot;
    requires transitive org.junit.jupiter.api;

    requires org.apache.commons.logging;

    requires org.apache.logging.log4j.core;
    requires static org.apache.logging.log4j.jul;
    requires static org.apache.logging.log4j.jpl;
    requires static org.apache.logging.log4j.jcl;
    requires com.truthbean.logger.core;
}
/**
 * Copyright (c) 2022 TruthBean(Rogar·Q)
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
 * Created on 2020-12-09 18:14
 */
module com.truthbean.logger.stdout.boot.test {
    requires com.truthbean.logger.stdout.boot;
    requires org.apache.logging.log4j;
    requires org.junit.jupiter.api;
    requires java.logging;
    requires org.apache.tomcat.juli;
    requires org.slf4j;

    opens com.truthbean.logger.stdout.boot.test;
}
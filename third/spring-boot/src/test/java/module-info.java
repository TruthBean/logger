/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
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
 * Created on 2020-12-02 18:39
 */
open module com.truthbean.logger.spring.boot.starter.test {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires com.truthbean.logger.core;
    requires com.truthbean.logger.stdout.boot;
    requires com.truthbean.logger.jcl;
    requires com.truthbean.logger.spring.boot;
}
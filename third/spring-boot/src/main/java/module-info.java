/**
 * Copyright (c) 2023 TruthBean(Rogar·Q)
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
 * Created on 2020-12-02 18:35
 */
open module com.truthbean.spring.boot {
    requires static spring.boot;
    requires static spring.context;
    requires transitive com.truthbean.logger.core;
    requires transitive com.truthbean.logger.stdout.boot;
    requires static spring.core;
    requires static spring.boot.starter;
    requires static spring.boot.autoconfigure;
}
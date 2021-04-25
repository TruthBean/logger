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
 * @since 0.5.0
 * Created on 2021-04-12 15:34
 */
module com.truthbean.logger.kotlin {
    requires transitive com.truthbean.logger.core;
    requires transitive kotlin.reflect;
    requires transitive kotlin.stdlib;

    exports com.truthbean.logger.kt;
    exports com.truthbean.kt;
}
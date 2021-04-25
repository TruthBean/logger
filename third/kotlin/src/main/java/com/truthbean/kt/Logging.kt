/**
 * Copyright (c) 2021 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *         http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.kt

import com.truthbean.Logger

/**
 * logger interface
 * @author TruthBean/Rogar·Q
 * @since 0.1.0
 * Created on 2020-06-22 23:34
 */
interface Logging {
    /**
     * factory logger by this java class
     */
    val logger: Logger
        get() = com.truthbean.LoggerFactory.getLogger(this.javaClass)
}
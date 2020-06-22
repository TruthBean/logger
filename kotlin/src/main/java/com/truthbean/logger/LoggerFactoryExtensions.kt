/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *         http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger

import com.truthbean.Logger
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 * @author TruthBean/Rogar·Q
 * @since 0.1.0
 * Created on 2020-06-22 23:34
 */

inline fun <reified T : Any> LoggerFactory.getLogger() = LoggerFactory.getLogger(T::class.java)

fun LoggerFactory.getLogger(kClass: KClass<*>): Logger {
    val qualifiedName = kClass.qualifiedName
    if (qualifiedName != null)
        return LoggerFactory.getLogger(qualifiedName)
    return LoggerFactory.getLogger(Logger::javaClass.name)
}

fun LoggerFactory.getLogger(property: KProperty<Class<*>>): Logger {
    return LoggerFactory.getLogger(property.name)
}

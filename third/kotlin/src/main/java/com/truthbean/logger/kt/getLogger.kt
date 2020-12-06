/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 *         http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.kt

import com.truthbean.Logger
import com.truthbean.logger.LogLevel
import com.truthbean.logger.LoggerFactory
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 * @author TruthBean/Rogar·Q
 * @since 0.1.0
 * Created on 2020-06-22 23:34
 */
inline fun <reified T : Any> LoggerFactory.getLogger(): Logger = LoggerFactory.getLogger(T::class.java)

inline fun <reified T : Any> LoggerFactory.getLogger(level: LogLevel): Logger = LoggerFactory.getLogger(level, T::class.java)

/**
 * factory logger by kotlin class
 */
fun LoggerFactory.getLogger(kClass: KClass<*>): Logger {
    val qualifiedName = kClass.qualifiedName
    if (qualifiedName != null)
        return LoggerFactory.getLogger(qualifiedName)
    return LoggerFactory.getLogger(Logger::javaClass.name)
}

/**
 * factory logger by kotlin class
 */
fun LoggerFactory.getLogger(level: LogLevel, kClass: KClass<*>): Logger {
    val qualifiedName = kClass.qualifiedName
    if (qualifiedName != null)
        return LoggerFactory.getLogger(level, qualifiedName)
    return LoggerFactory.getLogger(level, Logger::javaClass.name)
}

/**
 * factory logger by kotlin property
 */
fun LoggerFactory.getLogger(property: KProperty<Class<*>>): Logger {
    return LoggerFactory.getLogger(property.name)
}

/**
 * factory logger by kotlin property
 */
fun LoggerFactory.getLogger(level: LogLevel, property: KProperty<Class<*>>): Logger {
    return LoggerFactory.getLogger(level, property.name)
}

/**
 * logger interface
 */
interface Logging {
    /**
     * factory logger by this java class
     */
    val logger: Logger
        get() = LoggerFactory.getLogger(this.javaClass)
}
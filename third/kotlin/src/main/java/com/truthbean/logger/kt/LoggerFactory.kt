/**
 * Copyright (c) 2021 TruthBean(Rogar·Q)
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
import com.truthbean.logger.LoggerConfig
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 * @author TruthBean/Rogar·Q
 * @since 0.5.0-RELEASE
 * Created on 2020-12-28 17:34
 */
object LoggerFactory : com.truthbean.LoggerFactory {

    inline fun <reified T : Any> getLogger(): Logger = com.truthbean.LoggerFactory.getLogger(T::class.java)

    inline fun <reified T : Any> LoggerFactory.getLogger(level: LogLevel): Logger = com.truthbean.LoggerFactory.getLogger(level, T::class.java)

    fun getConfig(): LoggerConfig = com.truthbean.LoggerFactory.getConfig()

    fun flushConfig() = com.truthbean.LoggerFactory.flushConfig()

    fun destroy() = com.truthbean.LoggerFactory.destroy()

    fun getLogger(defaultLevel: LogLevel, clazz: Class<Any>): Logger =
        com.truthbean.LoggerFactory.getLogger(defaultLevel, clazz)

    fun getLogger(clazz: Class<Any>): Logger = com.truthbean.LoggerFactory.getLogger(clazz)

    fun getLogger(defaultLevel: LogLevel, loggerName: String): Logger =
        com.truthbean.LoggerFactory.getLogger(defaultLevel, loggerName)

    fun getLogger(loggerName: String): Logger = com.truthbean.LoggerFactory.getLogger(loggerName)

    /**
     * factory logger by kotlin class
     */
    fun getLogger(kClass: KClass<*>): Logger {
        val qualifiedName = kClass.qualifiedName
        if (qualifiedName != null)
            return com.truthbean.LoggerFactory.getLogger(qualifiedName)
        return com.truthbean.LoggerFactory.getLogger(Logger::javaClass.name)
    }

    /**
     * factory logger by kotlin class
     */
    fun getLogger(level: LogLevel, kClass: KClass<*>): Logger {
        val qualifiedName = kClass.qualifiedName
        if (qualifiedName != null)
            return com.truthbean.LoggerFactory.getLogger(level, qualifiedName)
        return com.truthbean.LoggerFactory.getLogger(level, Logger::javaClass.name)
    }

    /**
     * factory logger by kotlin property
     */
    fun getLogger(property: KProperty<Class<*>>): Logger =
        com.truthbean.LoggerFactory.getLogger(property.name)

    /**
     * factory logger by kotlin property
     */
    fun getLogger(level: LogLevel, property: KProperty<Class<*>>): Logger =
        com.truthbean.LoggerFactory.getLogger(level, property.name)
}
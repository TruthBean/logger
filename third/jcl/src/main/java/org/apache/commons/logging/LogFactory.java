/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.commons.logging;

import com.truthbean.Logger;
import com.truthbean.LoggerFactory;
import com.truthbean.core.util.ClassHelper;
import com.truthbean.logger.jcl.JclLogger;
import com.truthbean.logger.jcl.LogFactoryImpl;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-03 10:36
 */
public abstract class LogFactory {

    /**
     * Return the configuration attribute with the specified name (if any),
     * or <code>null</code> if there is no such attribute.
     *
     * @param name Name of the attribute to return
     */
    public abstract Object getAttribute(String name);

    /**
     * Return an array containing the names of all currently defined
     * configuration attributes.  If there are no such attributes, a zero
     * length array is returned.
     */
    public abstract String[] getAttributeNames();

    /**
     * Convenience method to derive a name from the specified class and
     * call <code>getInstance(String)</code> with it.
     *
     * @param clazz Class for which a suitable Log name will be derived
     */
    public abstract Log getInstance(Class<?> clazz);

    /**
     * Construct (if necessary) and return a <code>Log</code> instance,
     * using the factory's current set of configuration attributes.
     * <p>
     * <strong>NOTE</strong> - Depending upon the implementation of
     * the <code>LogFactory</code> you are using, the <code>Log</code>
     * instance you are returned may or may not be local to the current
     * application, and may or may not be returned again on a subsequent
     * call with the same name argument.
     *
     * @param name Logical name of the <code>Log</code> instance to be
     *  returned (the meaning of this name is only known to the underlying
     *  logging implementation that is being wrapped)
     */
    public abstract Log getInstance(String name);

    /**
     * Release any internal references to previously created {@link Log}
     * instances returned by this factory.  This is useful in environments
     * like servlet containers, which implement application reloading by
     * throwing away a ClassLoader.  Dangling references to objects in that
     * class loader would prevent garbage collection.
     */
    public abstract void release();

    /**
     * Remove any configuration attribute associated with the specified name.
     * If there is no such attribute, no action is taken.
     *
     * @param name Name of the attribute to remove
     */
    public abstract void removeAttribute(String name);

    /**
     * Set the configuration attribute with the specified name.  Calling
     * this with a <code>null</code> value is equivalent to calling
     * <code>removeAttribute(name)</code>.
     *
     * @param name Name of the attribute to set
     * @param value Value of the attribute to set, or <code>null</code>
     *  to remove any setting for this attribute
     */
    public abstract void setAttribute(String name, Object value);

    /**
     * Checks whether the supplied Throwable is one that needs to be
     * re-thrown and ignores all others.
     *
     * The following errors are re-thrown:
     * <ul>
     *   <li>ThreadDeath</li>
     *   <li>VirtualMachineError</li>
     * </ul>
     *
     * @param t the Throwable to check
     */
    protected static void handleThrowable(Throwable t) {
        if (t instanceof ThreadDeath) {
            throw (ThreadDeath) t;
        }
        if (t instanceof VirtualMachineError) {
            throw (VirtualMachineError) t;
        }
        // All other instances of Throwable will be silently ignored
    }

    /**
     * Construct (if necessary) and return a <code>LogFactory</code>
     * instance, using the following ordered lookup procedure to determine
     * the name of the implementation class to be loaded.
     * <p>
     * <ul>
     * <li>The <code>org.apache.commons.logging.LogFactory</code> system
     *     property.</li>
     * <li>The JDK 1.3 Service Discovery mechanism</li>
     * <li>Use the properties file <code>commons-logging.properties</code>
     *     file, if found in the class path of this class.  The configuration
     *     file is in standard <code>java.util.Properties</code> format and
     *     contains the fully qualified name of the implementation class
     *     with the key being the system property defined above.</li>
     * <li>Fall back to a default implementation class
     *     (<code>org.apache.commons.logging.impl.LogFactoryImpl</code>).</li>
     * </ul>
     * <p>
     * <em>NOTE</em> - If the properties file method of identifying the
     * <code>LogFactory</code> implementation class is utilized, all of the
     * properties defined in this file will be set as configuration attributes
     * on the corresponding <code>LogFactory</code> instance.
     * <p>
     * <em>NOTE</em> - In a multi-threaded environment it is possible
     * that two different instances will be returned for the same
     * classloader environment.
     */
    public static LogFactory getFactory() {
        return LogFactoryImpl.getInstance();
    }

    /**
     * Convenience method to return a named logger, without the application
     * having to care about factories.
     *
     * @param clazz Class from which a log name will be derived
     */
    public static Log getLog(Class<?> clazz) {
        Logger logger = LoggerFactory.getLogger(clazz);
        return new JclLogger(logger);
    }

    /**
     * Convenience method to return a named logger, without the application
     * having to care about factories.
     *
     * @param name Logical name of the <code>Log</code> instance to be
     *  returned (the meaning of this name is only known to the underlying
     *  logging implementation that is being wrapped)
     */
    public static Log getLog(String name) {
        Logger logger = LoggerFactory.getLogger(name);
        return new JclLogger(logger);
    }

    /**
     * Release any internal references to previously created {@link LogFactory}
     * instances that have been associated with the specified class loader
     * (if any), after calling the instance method <code>release()</code> on
     * each of them.
     *
     * @param classLoader ClassLoader for which to release the LogFactory
     */
    public static void release(ClassLoader classLoader) {

    }

    /**
     * Release any internal references to previously created {@link LogFactory}
     * instances, after calling the instance method <code>release()</code> on
     * each of them.  This is useful in environments like servlet containers,
     * which implement application reloading by throwing away a ClassLoader.
     * Dangling references to objects in that class loader would prevent
     * garbage collection.
     */
    public static void releaseAll() {

    }

    // ------------------------------------------------------ Protected Methods

    /**
     * Safely get access to the classloader for the specified class.
     * <p>
     * Theoretically, calling getClassLoader can throw a security exception,
     * and so should be done under an AccessController in order to provide
     * maximum flexibility. However in practice people don't appear to use
     * security policies that forbid getClassLoader calls. So for the moment
     * all code is written to call this method rather than Class.getClassLoader,
     * so that we could put AccessController stuff in this method without any
     * disruption later if we need to.
     * <p>
     * Even when using an AccessController, however, this method can still
     * throw SecurityException. Commons-logging basically relies on the
     * ability to access classloaders, ie a policy that forbids all
     * classloader access will also prevent commons-logging from working:
     * currently this method will throw an exception preventing the entire app
     * from starting up. Maybe it would be good to detect this situation and
     * just disable all commons-logging? Not high priority though - as stated
     * above, security policies that prevent classloader access aren't common.
     * <p>
     * Note that returning an object fetched via an AccessController would
     * technically be a security flaw anyway; untrusted code that has access
     * to a trusted JCL library could use it to fetch the classloader for
     * a class even when forbidden to do so directly.
     *
     * @since 1.1
     */
    protected static ClassLoader getClassLoader(Class<?> clazz) {
        return ClassHelper.getClassLoader(clazz);
    }

    /**
     * Returns the current context classloader.
     * <p>
     * In versions prior to 1.1, this method did not use an AccessController.
     * In version 1.1, an AccessController wrapper was incorrectly added to
     * this method, causing a minor security flaw.
     * <p>
     * In version 1.1.1 this change was reverted; this method no longer uses
     * an AccessController. User code wishing to obtain the context classloader
     * must invoke this method via AccessController.doPrivileged if it needs
     * support for that.
     *
     * @return the context classloader associated with the current thread,
     *  or null if security doesn't allow it.
     */
    protected static ClassLoader getContextClassLoader() {
        return directGetContextClassLoader();
    }

    /**
     * Return the thread context class loader if available; otherwise return null.
     * <p>
     * Most/all code should call getContextClassLoaderInternal rather than
     * calling this method directly.
     * <p>
     * The thread context class loader is available for JDK 1.2
     * or later, if certain security conditions are met.
     * <p>
     * Note that no internal logging is done within this method because
     * this method is called every time LogFactory.getLogger() is called,
     * and we don't want too much output generated here.
     *
     * @return the thread's context classloader or {@code null} if the java security
     *  policy forbids access to the context classloader from one of the classes
     *  in the current call stack.
     * @since 1.1
     */
    protected static ClassLoader directGetContextClassLoader() {
        ClassLoader classLoader = null;

        try {
            classLoader = Thread.currentThread().getContextClassLoader();
        } catch (SecurityException ex) {
            /**
             * getContextClassLoader() throws SecurityException when
             * the context class loader isn't an ancestor of the
             * calling class's class loader, or if security
             * permissions are restricted.
             *
             * We ignore this exception to be consistent with the previous
             * behavior (e.g. 1.1.3 and earlier).
             */
            // ignore
        }

        // Return the selected class loader
        return classLoader;
    }

    /**
     * Return a new instance of the specified <code>LogFactory</code>
     * implementation class, loaded by the specified class loader.
     * If that fails, try the class loader used to load this
     * (abstract) LogFactory.
     * <h2>ClassLoader conflicts</h2>
     * <p>
     * Note that there can be problems if the specified ClassLoader is not the
     * same as the classloader that loaded this class, ie when loading a
     * concrete LogFactory subclass via a context classloader.
     * <p>
     * The problem is the same one that can occur when loading a concrete Log
     * subclass via a context classloader.
     * <p>
     * The problem occurs when code running in the context classloader calls
     * class X which was loaded via a parent classloader, and class X then calls
     * LogFactory.getFactory (either directly or via LogFactory.getLog). Because
     * class X was loaded via the parent, it binds to LogFactory loaded via
     * the parent. When the code in this method finds some LogFactoryYYYY
     * class in the child (context) classloader, and there also happens to be a
     * LogFactory class defined in the child classloader, then LogFactoryYYYY
     * will be bound to LogFactory@childloader. It cannot be cast to
     * LogFactory@parentloader, ie this method cannot return the object as
     * the desired type. Note that it doesn't matter if the LogFactory class
     * in the child classloader is identical to the LogFactory class in the
     * parent classloader, they are not compatible.
     * <p>
     * The solution taken here is to simply print out an error message when
     * this occurs then throw an exception. The deployer of the application
     * must ensure they remove all occurrences of the LogFactory class from
     * the child classloader in order to resolve the issue. Note that they
     * do not have to move the custom LogFactory subclass; that is ok as
     * long as the only LogFactory class it can find to bind to is in the
     * parent classloader.
     *
     * @param factoryClass Fully qualified name of the <code>LogFactory</code>
     *  implementation class
     * @param classLoader ClassLoader from which to load this class
     * @param contextClassLoader is the context that this new factory will
     *  manage logging for.
     * @since 1.1
     */
    protected static LogFactory newFactory(final String factoryClass,
                                           final ClassLoader classLoader,
                                           final ClassLoader contextClassLoader) {
        return null;
    }

    /**
     * Method provided for backwards compatibility; see newFactory version that
     * takes 3 parameters.
     * <p>
     * This method would only ever be called in some rather odd situation.
     * Note that this method is static, so overriding in a subclass doesn't
     * have any effect unless this method is called from a method in that
     * subclass. However this method only makes sense to use from the
     * getFactory method, and as that is almost always invoked via
     * LogFactory.getFactory, any custom definition in a subclass would be
     * pointless. Only a class with a custom getFactory method, then invoked
     * directly via CustomFactoryImpl.getFactory or similar would ever call
     * this. Anyway, it's here just in case, though the "managed class loader"
     * value output to the diagnostics will not report the correct value.
     */
    protected static LogFactory newFactory(final String factoryClass,
                                           final ClassLoader classLoader) {
        return newFactory(factoryClass, classLoader, null);
    }

    /**
     * Implements the operations described in the javadoc for newFactory.
     *
     * @param factoryClass factoryClassName
     * @param classLoader used to load the specified factory class. This is
     *  expected to be either the TCCL or the classloader which loaded this
     *  class. Note that the classloader which loaded this class might be
     *  "null" (ie the bootloader) for embedded systems.
     * @return either a LogFactory object or a LogConfigurationException object.
     * @since 1.1
     */
    protected static Object createFactory(String factoryClass, ClassLoader classLoader) {
        return null;
    }

    /**
     * Indicates true if the user has enabled internal logging.
     * <p>
     * By the way, sorry for the incorrect grammar, but calling this method
     * areDiagnosticsEnabled just isn't java beans style.
     *
     * @return true if calls to logDiagnostic will have any effect.
     * @since 1.1
     */
    protected static boolean isDiagnosticsEnabled() {
        return false;
    }


    /**
     * Write the specified message to the internal logging destination.
     *
     * @param msg is the diagnostic message to be output.
     * @since 1.1
     */
    protected static void logRawDiagnostic(String msg) {
    }

    /**
     * Returns a string that uniquely identifies the specified object, including
     * its class.
     * <p>
     * The returned string is of form "classname@hashcode", ie is the same as
     * the return value of the Object.toString() method, but works even when
     * the specified object's class has overidden the toString method.
     *
     * @param o may be null.
     * @return a string of form classname@hashcode, or "null" if param o is null.
     * @since 1.1
     */
    public static String objectId(Object o) {
        if (o == null) {
            return "null";
        } else {
            return o.getClass().getName() + "@" + System.identityHashCode(o);
        }
    }

}
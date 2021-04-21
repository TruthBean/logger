/**
 * Copyright (c) 2021 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package org.slf4j.impl;

import com.truthbean.logger.slf4j.LoggerMDCAdapter;
import org.slf4j.spi.MDCAdapter;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-06 01:45
 */
@SuppressWarnings("unused")
public final class StaticMDCBinder {

    /**
     * The unique instance of this class.
     */
    public static final StaticMDCBinder SINGLETON = new StaticMDCBinder();

    private StaticMDCBinder() {
    }

    /**
     * Currently this method always returns an instance of {@link StaticMDCBinder}.
     * @return an MDC adapter
     */
    public MDCAdapter getMDCA() {
        return new LoggerMDCAdapter();
    }

    /**
     * Retrieve the adapter class name.
     * @return The adapter class name.
     */
    public String getMDCAdapterClassStr() {
        return LoggerMDCAdapter.class.getName();
    }
}

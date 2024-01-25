/**
 * Copyright (c) 2024 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.exception;

import java.io.Serial;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.0.1
 * Created on 2020-05-08 21:53
 */
public class NoLoggerProviderException extends RuntimeException {
    /**
     *
     */
    @Serial
    private static final long serialVersionUID = 6336490689226858998L;

    public NoLoggerProviderException() {
    }

    public NoLoggerProviderException(final String message) {
        super(message);
    }

    public NoLoggerProviderException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public NoLoggerProviderException(final Throwable cause) {
        super(cause);
    }

    public NoLoggerProviderException(final String message, final Throwable cause, final boolean enableSuppression,
            final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

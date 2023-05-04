/**
 * Copyright (c) 2023 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */

import com.truthbean.debbie.core.test.TestLogger;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-11-18 15:11
 */
open module com.truthbean.logger.test.core {
    requires com.truthbean.logger.core;
    requires org.junit.jupiter.params;
    requires org.junit.jupiter.api;
    requires org.junit.platform.commons;
    requires org.junit.jupiter.engine;
    requires org.junit.platform.engine;

    /*provides com.truthbean.Logger with
            TestLogger ;*/
}
/**
 * Copyright (c) 2020 TruthBean(Rogar·Q)
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
 * Created on 2020-12-03 11:17
 */
module com.truthbean.logger.jcl {
    requires com.truthbean.logger.core;
    exports org.apache.commons.logging;
    exports com.truthbean.logger.jcl;

    opens com.truthbean.logger.jcl;
    opens org.apache.commons.logging;
    opens org.apache.commons.logging.impl;

    provides org.apache.commons.logging.LogFactory with com.truthbean.logger.jcl.LogFactoryImpl;
}
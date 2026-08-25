/*
  Copyright (c) 2026 TruthBean(Rogar·Q)
  TruthBean Core is licensed under Mulan PSL v2.
  You can use this software according to the terms and conditions of the Mulan PSL v2.
  You may obtain a copy of Mulan PSL v2 at:
  http://license.coscl.org.cn/MulanPSL2
  THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
  See the Mulan PSL v2 for more details.
 */
package com.truthbean;

import com.truthbean.core.TruthBeanVersion;

/**
 * TruthBean Logger框架版本信息工具类。
 * 用于获取当前 TruthBean Logger的版本号，优先从 MANIFEST.MF 的 Implementation-Version 中读取，
 * 若无法获取则返回默认版本号。
 *
 * @author TruthBean
 * @since 3.3.0
 * Created on 2022/03/31 14:10.
 */
public class TruthBeanLoggerVersion extends TruthBeanVersion {
    /** 工具类，禁止外部实例化 */
    protected TruthBeanLoggerVersion() {
    }

    /**
     * 获取当前 TruthBean 框架的版本号。
     * 优先从 Jar 包 MANIFEST.MF 中读取 Implementation-Version，
     * 如果无法获取或值为 "null"，则返回默认版本 "0.6.3-RELEASE"。
     *
     * @return 版本号字符串，如 "0.6.3-RELEASE"
     */
    public static String getVersion() {
        return getVersion(TruthBeanLoggerVersion.class, "0.6.3-RELEASE");
    }
}

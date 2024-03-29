/**
 * Copyright (c) 2024 TruthBean(Rogar·Q)
 * Debbie is licensed under Mulan PSL v2.
 * You can use this software according to the terms and conditions of the Mulan PSL v2.
 * You may obtain a copy of Mulan PSL v2 at:
 * http://license.coscl.org.cn/MulanPSL2
 * THIS SOFTWARE IS PROVIDED ON AN "AS IS" BASIS, WITHOUT WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO NON-INFRINGEMENT, MERCHANTABILITY OR FIT FOR A PARTICULAR PURPOSE.
 * See the Mulan PSL v2 for more details.
 */
package com.truthbean.logger.springboot.test;

import com.truthbean.Logger;
import com.truthbean.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author TruthBean/Rogar·Q
 * @since 0.4.0
 * Created on 2020-12-02 15:56
 */
@SpringBootApplication
public class SpringBootLoggerTest {

    public static void main(String[] args) {
        Thread.currentThread().setName("TruthBean-SpringBoot-Logger");
        LOGGER.info("bababababbaa....");
        SpringApplication.run(SpringBootLoggerTest.class, args);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootLoggerTest.class);
}

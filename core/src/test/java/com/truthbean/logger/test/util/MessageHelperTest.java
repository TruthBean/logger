package com.truthbean.logger.test.util;

import com.truthbean.logger.util.MessageHelper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author TruthBean/Rogar·Q
 * @since Created on 2020-12-02 10:33
 */
class MessageHelperTest {

    @Test
    void format() {
        String format= "}中{}文}中{}文}中{}{中{}}中{}中{中中{}}{";
        Object[] args = new Object[]{"123"};
        var sb = MessageHelper.format(format, args);
        System.out.println(sb.toString());
    }
}
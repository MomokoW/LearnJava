package com.momoko.java4;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by momoko on 2021/1/24.
 */
public class GrilBoyTest {
    @Test
    public void test1() {
        Boy boy = new Boy();

    }

    public String getGirlName(Boy boy) {
        Optional<Boy> boy1 = Optional.of(boy);
        boy1.orElse(null);
        return boy.getGirl().getName();
    }
}
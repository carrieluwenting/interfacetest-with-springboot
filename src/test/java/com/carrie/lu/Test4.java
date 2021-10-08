package com.carrie.lu;


import org.junit.jupiter.api.Test;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class Test4 extends DemoTest{

    @Test
    public void testSayHello() throws InterruptedException {
        sleep(1000);
        assertThat("Checking", 1, equalTo(1));
    }

    @Test
    public void testSayHello2() throws InterruptedException {
        sleep(1000);
        assertThat("Checking", 1, equalTo(1));
    }

    @Test
    public void testSayHello3() throws InterruptedException {
        sleep(1000);
        assertThat("Checking", 1, equalTo(1));
    }

}

package com.heastie.swgoh.automation;

import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Component;

@Component
public class Delay {
    public static void of(long milliseconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

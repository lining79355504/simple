package com.mort.jvm;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author:  lining17
 * Date :  2020-05-19
 */
public class Jvm {


private static final Logger logger = LoggerFactory.getLogger(Jvm.class);


    @Test
    public void omitStackTraceInFastThrowTest() {
        String str = null;
        int i = 0;
        while (i < 10000) {
            try {
                str.length();
            } catch (Exception e) {
//                logger.error("error", e);
                e.printStackTrace();
            }
            i++;
        }

        try {
            Thread.currentThread().sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        i = 0;
        while (i < 10) {
            try {
                throw new NullPointerException();
            } catch (Exception e) {
                logger.error("error", e);
            }
            i++;
        }

    }


}

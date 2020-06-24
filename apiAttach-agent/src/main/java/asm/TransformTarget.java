package asm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Author:  lining17
 * Date :  2020-06-12
 */


public class TransformTarget {

    private static final Logger log = LoggerFactory.getLogger(TransformTarget.class);

    public static void main(String[] args) {
        while (true) {
            try {
                Thread.sleep(3000L);
            } catch (Exception e) {
                break;
            }
            printSomething(2, "3str", Arrays.asList("1s", "2s", "3s"));
        }
    }

    public static void printSomething(int a, String b, List<String> list) {
        log.info("info {} , {} , {}", list, b , a);
        System.out.println("hello121");
        log.info("end info {}", list);
    }
}


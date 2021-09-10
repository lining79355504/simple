package com.mort.ThrowFinalTest;

import java.util.concurrent.CompletionException;

/**
 * @author mort
 * @Description
 * @date 2021/4/1
 **/
public class ThrowFinalTest {
        public static void main(String[] args) {
            System.out.print(getNumber(0));
            System.out.print(getNumber(1));
            System.out.print(getNumber(2));
            System.out.print(getNumber(4));
        }

        public static int getNumber(int num) {
            try {
                int result = 2 / num;
                return result;
            } catch (Exception exception) {
                throw exception;
//                return 0;
            } finally {
                // 没有return的话 执行完finally可以抛异常
//                if (num == 0) {
//
//                    return -1;
//                }
                if (num == 1) {

                    return 1;
                }
            }
        }
}

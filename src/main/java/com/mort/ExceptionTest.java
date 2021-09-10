package com.mort;

import java.util.Arrays;

/**
 *   Created by mortli on 1/10/17.
 *
 * 　finally总是在控制转移语句（break，continue，return等）执行之前执行。
 *
 */
public class ExceptionTest {


    public static class a{

        public static void a_exception() throws Exception{
            throw new Exception("i am Exception");
        }


    };

    public static class MyException extends Exception{

        public String message ;

        @Override
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public MyException(String message){   //StringBuild (Thread unSafe ) > StringBuffer (thread safe)> String
            this.message = message ;
            System.out.println(message+"i am MyException");   //
        }

    }

    public static void main(String[] args) {

        try {

            //a.a_exception();    // 默认异常
            throw new MyException("112312312");  // 自定义异常

        }
//        catch (MyException myException){
//            myException.getMessage() ;
//
//        }
        catch (Exception e){

            e.printStackTrace();

        }

        while (true) {
            try {
                throw new Exception("test");
            } catch (Exception e) {
                System.out.println("args = " + Arrays.deepToString(args));
                break;
            } finally {
                System.out.println("finally");
            }
        }

    }
}

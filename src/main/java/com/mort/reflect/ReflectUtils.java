package com.mort.reflect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author mort
 * @Description
 * @date 2021/9/14
 **/
public class ReflectUtils {

    private static final Logger logger = LoggerFactory.getLogger(ReflectUtils.class);

    public static void setInvoke(Object data, String filedName, Object targetObj) {

        try {
            Class<?> targetClass = Class.forName(targetObj.getClass().getName());
            PropertyDescriptor pd = new PropertyDescriptor(filedName, targetClass);
            Method writeMethod = pd.getWriteMethod();
            writeMethod.invoke(targetObj, data);
        } catch (Throwable throwable) {
            logger.error("error {}", throwable);
        }
    }


    public static Object getInvoke(String filedName, Object targetObj) {

        try {
            Class<?> targetClass = Class.forName(targetObj.getClass().getName());
            PropertyDescriptor pd = new PropertyDescriptor(filedName, targetClass);
            Method readMethod = pd.getReadMethod();
            Object result = readMethod.invoke(targetObj,  new Object[]{});
            return result;
        } catch (Throwable throwable) {
            logger.error("error {}", throwable);
        }
        return null;
    }




    public static void main(String[] args) {


        String str = "测试";

        try {
            new String(str.getBytes("gbk"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        A a = new A();
        setInvoke(1, "age", a);

        getInvoke("age", a);



    }


    static class A {
        private String str;

        private Integer age;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}

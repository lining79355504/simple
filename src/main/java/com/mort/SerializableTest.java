package com.mort;

import com.alibaba.fastjson.JSON;

import java.io.*;


/**
 * Created by mortli on 11/15/16.
 */
public class SerializableTest {


    public static void main(String[] args) throws Exception {


        File file = new File(" person.out ");
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        Person person = new Person(" John ", 101L);
        oout.writeObject(person);
        oout.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject();  //  没有强制转换到Person类型
        oin.close();
        System.out.println(JSON.toJSONString(newPerson));

    }

}

package com.mort.serial;

import java.io.ObjectStreamClass;
import java.io.Serializable;

/**
 * Created by mortli on 1/20/17.
 */
public class Student implements Serializable {


//    private static final long serialVersionUID = 1L;

    private String name ;

    private int age ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    // JVM 默认序列化
    public static void main(String[] args) {
        //已经有了 serialVersionUID  会返回已有的serialVersionUID
        ObjectStreamClass c = ObjectStreamClass.lookup(Student.class);
        long serialID = c.getSerialVersionUID();
        System.out.println(serialID);
    }
}

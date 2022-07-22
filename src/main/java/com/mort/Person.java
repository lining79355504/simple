package com.mort;

import java.io.*;

/**
 * @author mort
 * @Description
 * @date 2021/8/20
 **/
public class Person implements Externalizable {

    private static final long serialVersionUID = -3196989738210036107L;

    private String name;

    private Long no;

    public Person() {
    }

    public Person(String name, Long no) {
        this.name = name;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

//    @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//        out.writeUTF(name);
//        out.writeLong(no);
//    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = in.readUTF();
//        this.no =
    }
}


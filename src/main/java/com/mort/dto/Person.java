package com.mort.dto;

import java.io.Serializable;

/**
 * @author mort
 * @Description
 * @date 2021/8/20
 **/
public class Person implements Serializable {

    private static final long serialVersionUID = -3196989738210036107L;

    private String name;

    private Integer no;

    public Person() {
    }

    public Person(String name, Integer no) {
        this.name = name;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }
}


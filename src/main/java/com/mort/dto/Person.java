package com.mort.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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


//    public BigDecimal getField(String orderBy) throws NoSuchFieldException, IllegalAccessException {
//        return new BigDecimal(getClass().getDeclaredField(orderBy).get(this).toString());
//    }

    public <T extends Comparable<T>> T getField(String orderBy) throws NoSuchFieldException, IllegalAccessException {
        return (T) getClass().getDeclaredField(orderBy).get(this);
    }

    public static void main(String[] args) {

        String sortFiled = "no";

        List<Person> data = new ArrayList<>();

        List<Person> sortedListByField = data.stream().sorted(Comparator.comparing(vo -> {
            try {
                return vo.getField(sortFiled);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return BigDecimal.ZERO;
        })).collect(Collectors.toList());
    }

}


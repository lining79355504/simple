package com.mort.stream;

import java.util.*;

/**
 * Created by suoer on 3/31/17.
 */
/*
*
* -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/path/heap/dump    oom 自动生成dump 文件
* */
public class ParalleStream {


    public static void main(String[] args) {

        // general  a list
        List<String> strList = genStrList(8000000 , 20);
        Long statTime = System.currentTimeMillis();

        //for cost
        int count = 0 ;
        for (String item:strList) {
            if(item.length() > 4){
                count++ ;
            }
        }
        Long endTime = System.currentTimeMillis();
        System.out.println("normal spent "+ (endTime-statTime));
        System.out.println("count "+ count);


        // stream cost
        count = 0 ;
        statTime = System.currentTimeMillis();
        strList.stream().filter(item -> item.length()> 4).count();
        for (String item:strList) {
            if(item.length() > 4){
                count++ ;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("stream spent "+ (endTime-statTime));
        System.out.println("count "+ count);

        // paralle stream cost
        count = 0 ;
        statTime = System.currentTimeMillis();
        strList.parallelStream().filter(item -> item.length()> 4).count();
        for (String item:strList) {
            if(item.length() > 4){
                count++ ;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("paralle stream spent "+ (endTime-statTime));
        System.out.println("count "+ count);



    }


    public static List generalRandom(int count ){

        List strList = new ArrayList();

        for (int i = 0; i < count; i++) {

            strList.add(UUID.randomUUID().toString());
            
        }

        return strList;


    }

    public static List genStrList(int count , int length){

        Random ran = new Random();
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            for (int j = ran.nextInt(length); j >0 ; j--) {
                sb.append((char)('a' + ran.nextInt(26)));
            }
            sb.append(" ");
        }

        return Arrays.asList(sb.toString().split(" "));
    }
}

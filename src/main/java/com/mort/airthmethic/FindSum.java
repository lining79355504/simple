package com.mort.airthmethic;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by mortli on 3/7/17.
 */
public class FindSum {

    @Test
    public void testSum(){

        int [] a = {1,2,3,4,5,6,7,8};
        int sum = 6 ;

        System.out.println(Arrays.toString(a));

        findSum(a ,0 , sum);
    }

    public void findSum(int [] a ,int curson, int sum ){

        for (int i = 0 ; i < a.length ; i++){

            //findSum(tmp , curson+1 , tmp.length);

        }



    }
}

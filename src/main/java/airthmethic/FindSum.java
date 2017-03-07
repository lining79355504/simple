package airthmethic;

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

        findSum(a , sum);
    }

    public void findSum(int [] a , int sum ){

        for (int i = 0 ; i < a.length ; i++){

            int left = i ;
            int right = i ;
            int tmp = 0 ;

            int[] ret = new  int[20] ;

            while(right < a.length){
                tmp += a[right];
                ret[right] = a[right];
                if(tmp == sum ){

                    System.out.println(Arrays.toString(ret));
                }
                right ++ ;
            }

        }



    }
}

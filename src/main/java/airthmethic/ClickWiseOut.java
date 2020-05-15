package airthmethic;

import javax.servlet.Servlet;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by mortli on 3/6/17.
 */
public class ClickWiseOut {
        //顺时针打印一个矩阵

        @Test
        public void test(){
            float a = 42 ;
            double b = 42.0 ;
            BigDecimal c = new BigDecimal(42);

            System.out.println(a==b);

            int[][] num = new int[100][100];
            int n = 6;
            int count =1;

            for(int i=0;i<n;i++){
                for(int j =0;j<n;j++){
                    num[i][j]=count++;
                }
            }
            output(num,0,n-1);
        }

        public void output(int[][] num,int start,int end){
            if(start>end || end<=0)return;
            for(int i=start;i<=end;i++){
                System.out.println(num[start][i]);
            }
            for(int i=start+1;i<=end;i++){
                System.out.println(num[i][end]);
            }

            for(int i=end-1;i>=start;i--){
                System.out.println(num[end][i]);
            }
            for(int i=end-1;i>start;i--){
                System.out.println(num[i][start]);
            }

            output(num,start+1,end-1);

        }



}

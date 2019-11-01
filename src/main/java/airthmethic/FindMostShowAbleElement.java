package airthmethic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.System.exit;

/**
 * Created by mort on 15/06/2017.
 */
public class FindMostShowAbleElement {

    private static final Logger logger = LoggerFactory.getLogger(FindMostShowAbleElement.class);

    public static void main(String[] args) {

        int aI = 6;
        long b = 7;

        int a[] = {1, 2, 2, 2, 2, 6, 2, 5, 34, 56};

        int tmp[] = a;   // 地址相同 改变任何一个变量会互相改变  C语言指针赋值类似   memcpy() 不会有这样的情况
        // tmp[0]=a[0];

        tmp[0]=3;
        logger.info("{}" , a);
        for (int i = 0; i < a.length; i++) {
            int sameFlag = 0;
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] == a[i]) {
                    sameFlag++;
                }
            }

            if (sameFlag > 1) {
                for (int j = i; j < tmp.length; j++) {
                    if (tmp[j] == a[i]) {
                        recursionArrayAssignValue(tmp , a[i] , i);
                    }
                }

            }


            System.out.println(a[0]);
            logger.info("tmp is  {}", tmp);
            logger.info("a is  {}", a);

        }

        exit(0);


    }


    static int[] recursionArrayAssignValue(int b[] , int value , int offset ) {

        //C语言不支持不定长数组，要么malloc，要么在动态的指定它的长度   int* p = (int*)malloc(num);
        //动态数组不能初始化，可使用memset
        //int a[256]={1}; 第一个元素为1 , 其余的都初始化为0
        int[] tmp = new int[b.length-1];  //  Java 特殊制定长度
        for (int i= offset ; i< b.length-1 ; i++){
                b[i] = b[i+1];
        }
        for (int i= 0 ; i< tmp.length ; i++){
            tmp[i] = b[i];
        }



        logger.info("recursionArrayAssignValue is : {}",tmp);

        return tmp;

    }


}
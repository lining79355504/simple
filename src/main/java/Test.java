import javafx.scene.layout.BackgroundImage;

import java.math.BigDecimal;

/**
 * Created by mortli on 11/15/16.
 */
public class Test {


    static String b_a = new String("112312312");
    static int a_a = 0 ;


    public static void main(String[] args) {







        TestA testA = new TestA(a_a);
        TestB testB = new TestB(b_a);
        testB.changeB();
        testA.changeB();
        System.out.println("a_a is " + a_a );
        System.out.println("b_a is " + b_a );


        String b = new String("12");
        Object a = null;

        BigDecimal c = new BigDecimal(3);

        BigDecimal d = new BigDecimal(2);

        if(d.intValue() == 0){

        }

        if(a!=null && a.equals("1") ){     //&&  机制 从前往后执行 只要有一个出现错误就不执行后面的

            System.out.println("asasa");



        }

        System.out.println("a ".trim()+1);
    }
}

/**
 * Created by mortli on 11/15/16.
 */
public class Test {


    public static void main(String[] args) {

        Object a = null;

        if(a!=null && a.equals("1") ){     //&&  机制 从前往后执行 只要有一个出现错误就不执行后面的

            System.out.println("asasa");



        }

        System.out.println("a ".trim()+1);
    }
}

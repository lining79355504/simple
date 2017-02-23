import java.util.UUID;

import static java.lang.String.valueOf;

/**
 * Created by mortli on 11/8/16.
 */




public class xStreamTest {

    public static void main(String[] args) throws Exception {

        for(int i=0 ; i<100000000; i++){


            uuid();

        }
    }

    public static void uuid() {
        

        UUID.randomUUID().toString().intern();   //String 不变类 新建的String 会直接复制值给新的String  放在永久区

    }
}




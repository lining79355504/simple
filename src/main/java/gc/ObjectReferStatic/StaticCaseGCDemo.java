package gc.ObjectReferStatic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by mort on 16/06/2017.
 */
public class StaticCaseGCDemo {

    //public static HashMap a;  编译到构造函数a.put的位置 会有npe
    public static HashMap a = new HashMap();

    // 构造方法默认是static的 在全局共享区
    StaticCaseGCDemo(){
        a.put("key_a" , "asadasdasdas");
        a.put("key_b" , "asadasdasdas");
        a.put("key_c" , "asadasdasdas");
        a.put("key_d" , "asadasdasdas");

    }


    public void initList(){

        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 100000; i++) {
            arrayList.add("i am list ");
        }


    }





}

package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mort on 16/05/2017.
 */
public class IteratorRemove {


    public static void main(String[] args) {


        List list = new ArrayList();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        for (int i = 0; i < list.size(); i++) {
                list.get(i);
            if(Integer.valueOf(String.valueOf(list.get(i))) == 2){
                list.remove(i);
            }
            
        }

        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object value = iterator.next();
            if (Integer.valueOf(value.toString()) == 1) {
                //list.remove(value);  // 会出现concurrentException  具体原因看源码 
                iterator.remove();   //不会出现concurrentException

            }
        }

//        for (:
//             ) {
//
//        }     foreach 编译后会变成 iterator remove add  会出现concurrentException

    }
}

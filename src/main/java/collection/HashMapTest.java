package collection;

import org.apache.commons.collections4.SetUtils;

import java.util.*;

/**
 * Created by mortli on 2/23/17.
 */
public class HashMapTest {
       /**
         * @param args
         */
        public static void main(String[] args) {

            testList2Array();
            testArray2List();
            testSet2List();
            testList2Set();
            testSet2Array();
            testArray2Set();
            testMap2Set();
            testMap2List();
        }

        private static void testMap2List() {

            Map<String, String> map = new HashMap<String , String>();
            map.put("A", "ABC");
            map.put("K", "KK");
            map.put("L", "LV");

            // 将Map Key 转化为List
            List<String> mapKeyList = new ArrayList<String>(map.keySet());
            System.out.println("mapKeyList:"+mapKeyList);

            // 将Map Key 转化为List
            List<String> mapValuesList = new ArrayList<String>(map.values());
            System.out.println("mapValuesList:"+mapValuesList);

        }

        private static void testMap2Set() {

            Map<String, String> map = new HashMap<String, String>();
            map.put("A", "ABC");
            map.put("K", "KK");
            map.put("L", "LV");

            // 将Map 的键转化为Set
            Set<String> mapKeySet = map.keySet();
            System.out.println("mapKeySet:"+mapKeySet);

            // 将Map 的值转化为Set
            Set<String> mapValuesSet = new HashSet<String>(map.values());
            System.out.println("mapValuesSet:"+mapValuesSet);
        }

        private static void testArray2Set() {

            String[] arr = {"AA","BB","DD","CC","BB"};

            //数组-->Set
            Set<String> set = new HashSet<String>(Arrays.asList(arr));
            System.out.println(set);
        }

        private static void testSet2Array() {
            Set<String> set = new HashSet<String>();
            set.add("AA");
            set.add("BB");
            set.add("CC");

            String[] arr = new String[set.size()];
            //Set-->数组
            set.toArray(arr);
            System.out.println(Arrays.toString(arr));
        }

        private static void testList2Set() {

            List<String> list = new ArrayList<String>();
            list.add("ABC");
            list.add("EFG");
            list.add("LMN");
            list.add("LMN");

            //List-->Set
            Set<String> listSet = new HashSet<String>(list);
            System.out.println(listSet);
        }

        private static void testSet2List() {     // set 与list 区别 element 不会重复   都继承collection

            Set<String> set = new HashSet<String>();
            set.add("BB");
            set.add("BB");
            set.add("AA");
            set.add("CC");

            SetUtils.orderedSet(set);
            System.out.println(set);
            System.out.println(SetUtils.orderedSet(set));

            //Set --> List
            List<String> setList = new ArrayList<String>(set);
            System.out.println(setList);
        }

        private static void testList2Array() {
            //List-->数组
            List<String> list = new ArrayList<String>();
            list.add("AA");
            list.add("BB");
            list.add("CC");
            Object[] objects = list.toArray();//返回Object数组
            System.out.println("objects:"+Arrays.toString(objects));

            String[] arr = new String[list.size()];
            list.toArray(arr);//将转化后的数组放入已经创建好的对象中
            System.out.println("strings1:"+Arrays.toString(arr));
        }

        private static void testArray2List() {
            //数组-->List
            String[] ss = {"JJ","KK"};
            List<String> list1 = Arrays.asList(ss);
            List<String> list2 = Arrays.asList("AAA","BBB");
            System.out.println(list1);
            System.out.println(list2);
        }

    }


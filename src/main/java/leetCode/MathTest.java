package leetCode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  lining17
 * Date :  2020-05-26
 */
public class MathTest {

    private static final Logger log = LoggerFactory.getLogger(MathTest.class);

    //    [[1,2,3],[1,3,4],[1,4,5]]
    public void arrange(int[] arr, int n, List<List<Integer>> ret) {
        if (n <= 0) {
            log.info("{}",ret);
            return;
        }
        List<List<Integer>> newRet = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (5 > ret.size()) {
                List<Integer> sTmp = new ArrayList<>();
                sTmp.add(arr[i]);
                ret.add(sTmp);
                newRet = ret;
                continue;
            }
            int count = ret.size();
            for (int i1 = 0; i1 < count; i1++) {
                List<Integer> sTmp = new ArrayList<>();
                sTmp.addAll(ret.get(i1));
                sTmp.add(arr[i]);
                newRet.add(sTmp);
            }
        }
        n--;
        arrange(arr, n, newRet);
    }

    public int[] sortArray(int[] array) {
        int length = array.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
        return array;
    }

    @Test
    public void combinationTest() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] unsortArr = {4, 2, 3, 1, 5};
        List<List<Integer>> ret = new ArrayList<>();
        arrange(arr, 3, ret);
        sortArray(unsortArr);
    }
}

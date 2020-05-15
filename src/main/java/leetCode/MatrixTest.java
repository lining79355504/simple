package leetCode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:  lining17
 * Date :  2020-05-12
 */
public class MatrixTest {

    private static final Logger logger = LoggerFactory.getLogger(MatrixTest.class);

    private static final int[][] array = {
            {1, 3, 5, 9},
            {8, 1, 3, 4},
            {5, 0, 6, 1},
            {8, 8, 4, 0}
    };


    //找出矩阵最短路径(向右 向下)  二维  向右向下找最小值即可获得最小路径
    public void findShortPath(int[][] array) {
        List<Integer> shortPath = new ArrayList<>();

        shortPath.add(array[0][0]);//默认添加第一个

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i + 1 < array.length && j + 1 < array[i].length) {
                    int down = array[i + 1][j];
                    int right = array[i][j + 1];
                    //向下的要修改指标 向右的不用
                    if (right > down) {
                        shortPath.add(down);
                        i = i + 1;
                        j = j - 1;
                    } else {
                        shortPath.add(right);
                    }
                    //边界处理 注意先add后 增加指标
                } else if (i + 1 >= array.length && j + 1 < array[i].length) {
                    shortPath.add(array[i][j + 1]);
                } else if (j + 1 >= array[i].length && i + 1 < array.length) {
                    shortPath.add(array[i + 1][j]);
                    i = i + 1;
                    j = j - 1;
                }
            }
        }
        logger.info("shortPath {}", shortPath);
    }

    //找出矩阵中的最大子矩阵
    private void findMaxMatrix(int[][] array) {
//        int max[][]

    }

    @Test
    public void findShortPathTest(){
        findShortPath(array);
    }


    //组合


    //排列


}

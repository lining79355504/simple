## 概述

找出一条从左上角到右下角的路径，路径上数字之和最小。

## 题解

#### 方法 1： 暴力

暴力就是利用递归，对于每个元素我们考虑两条路径，向右走和向下走，在这两条路径中挑选路径权值和较小的一个。
![\mathrm{cost}(i,j)=\mathrm{grid}\[i\]\[j\]+\min\big(\mathrm{cost}(i+1,j),\mathrm{cost}(i,j+1)\big) ](./p___mathrm{cost}_i,_j_=mathrm{grid}_i__j__+_min_big_mathrm{cost}_i+1,_j_,_mathrm{cost}_i,_j+1__big___.png) 

```Java []
public class Solution {
    public int calculate(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
    }
    public int minPathSum(int[][] grid) {
        return calculate(grid, 0, 0);
    }
}
```
**复杂度分析**

* 时间复杂度 ：![O\big(2^{m+n}\big) ](./p__Obig_2^{m+n}big__.png) 。每次移动最多可以有两种选择。
* 空间复杂度 ：*O(m+n)*。递归的深度是 *m+n*。


#### 方法 2：二维动态规划

**算法**

我们新建一个额外的 *dp* 数组，与原矩阵大小相同。在这个矩阵中，*dp(i, j)* 表示从坐标 *(i, j)* 到右下角的最小路径权值。我们初始化右下角的 *dp* 值为对应的原矩阵值，然后去填整个矩阵，对于每个元素考虑移动到右边或者下面，因此获得最小路径和我们有如下递推公式：
![dp(i,j)=\mathrm{grid}(i,j)+\min\big(dp(i+1,j),dp(i,j+1)\big) ](./p___dp_i,_j_=_mathrm{grid}_i,j_+minbig_dp_i+1,j_,dp_i,j+1_big___.png) 
注意边界情况。下图描述了这个过程：


  [image.png](https://pic.leetcode-cn.com/4e2416307ac8e4d2acb9b669a772d4c598f89c5f9e01e7881a4981c261814a58-image.png)  [image.png](https://pic.leetcode-cn.com/e1fc103df720d00cfb3f0f8923eb9314c4ce525066f36bb***f8083249ae06a3-image.png)  [image.png](https://pic.leetcode-cn.com/bf444645337befb64986c651ecde7ec3666c9880bfefdc246e85729d95b6dd56-image.png)  [image.png](https://pic.leetcode-cn.com/2a29d93bd39d73a18936d86254c68e39d7c1478c41eb69711966fc9ee21735a7-image.png)  [image.png](https://pic.leetcode-cn.com/9dd0efa153690afee1d0991581784aa646c7dac7e4af72a64709414212d9ed03-image.png)  [image.png](https://pic.leetcode-cn.com/5b4f14f7c277ded372b40dffbcf5400b0904783ff5ed0a41e214dde6fecaaec3-image.png)  [image.png](https://pic.leetcode-cn.com/8ade7ff2ee8c5f863c48538dcc221dfaec83ad26ab2e036daaf12daa96d13cc5-image.png)  [image.png](https://pic.leetcode-cn.com/86c093e73ae586ae49449c1514bd94d2b7a9baa7b25e8dbed4807b29c9636fcd-image.png)  [image.png](https://pic.leetcode-cn.com/8b4da8e01066783aeb718c6f99377609c705b6ff7039d4363ef3c10960c43280-image.png)  [image.png](https://pic.leetcode-cn.com/5fa9062444eee03fad29ad6fb87933e7edcaffca4d497377069a461e6c7b538e-image.png)  [image.png](https://pic.leetcode-cn.com/1589df79a78a87d81753e25890b62a144b0c14d0c1c9c5f58909b055e1e06d9c-image.png)  [image.png](https://pic.leetcode-cn.com/da2eee284b84b0bc3d7ea03eb05a81f2ed4e89477afeec3af6e897cd6879f432-image.png)  [image.png](https://pic.leetcode-cn.com/33145308603f2d2ab5f49f54498303300b66fa3d8bb1ead7541a2288dc009524-image.png)  [image.png](https://pic.leetcode-cn.com/683294dde40aaa00e4d43c84426389b3409b9fc463cc3e78df78027dfcf70dba-image.png)  [image.png](https://pic.leetcode-cn.com/510ca1dddbdb31e926c362aa27e6f03f7a08112d95704f6fd425d2b33da54a01-image.png)  [image.png](https://pic.leetcode-cn.com/f7de8649cc249515fa4a442508312b65e76684c5113d3112d55260dcc3cbe112-image.png)  [image.png](https://pic.leetcode-cn.com/fe9ed5dc483d2f0ce8ea16f0b9c880a90c82265f522572b7615a779dbd2c486c-image.png) 


```Java []
public class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[i][j] = grid[i][j] +  dp[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + dp[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[i][j] = grid[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
                else
                    dp[i][j] = grid[i][j];
            }
        }
        return dp[0][0];
    }
}
```
**复杂度分析**

* 时间复杂度 ：*O(mn)*。遍历整个矩阵恰好一次。
* 空间复杂度 ：*O(mn)*。额外的一个同大小矩阵。

#### 方法 3：一维动态规划

**算法**

在上个解法中，我们可以用一个一维数组来代替二维数组，*dp* 数组的大小和行大小相同。这是因为对于某个固定状态，只需要考虑下方和右侧的节点。首先初始化 *dp* 数组最后一个元素是右下角的元素值，然后我们向左移更新每个 *dp(j)* 为：

![dp(j)=\mathrm{grid}(i,j)+\min\big(dp(j),dp(j+1)\big) ](./p___dp_j_=mathrm{grid}_i,j_+minbig_dp_j_,dp_j+1_big___.png) 

我们对于每一行都重复这个过程，然后向上一行移动，计算完成后 *dp(0)* 就是最后的结果。

 ```Java []
 public class Solution {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[j] = grid[i][j] +  dp[j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + dp[j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                else
                    dp[j] = grid[i][j];
            }
        }
        return dp[0];
    }
}
 ```
**复杂度分析**

* 时间复杂度 ：*O(mn)*。遍历整个矩阵恰好一次。
* 空间复杂度 ：*O(n)*。额外的一维数组，和一行大小相同。


#### 方法 4：动态规划（不需要额外存储空间）

**算法**

和方法 2 相同，惟一的区别是，不需要用额外的 *dp* 数组，而是在原数组上存储，这样就不需要额外的存储空间。递推公式如下：
![\mathrm{grid}(i,j)=\mathrm{grid}(i,j)+\min\big(\mathrm{grid}(i+1,j),\mathrm{grid}(i,j+1)\big) ](./p___mathrm{grid}_i,_j_=mathrm{grid}_i,j_+min_big_mathrm{grid}_i+1,j_,_mathrm{grid}_i,j+1_big___.png) 
```Java []
public class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    grid[i][j] = grid[i][j] +  grid[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j],grid[i][j + 1]);
            }
        }
        return grid[0][0];
    }
}
```
**复杂度分析**

* 时间复杂度 ：*O(mn)*。遍历整个矩阵恰好一次。
* 空间复杂度 ：*O(1)*。不需要额外空间。
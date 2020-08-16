package org.example;

import java.util.*;

public class WeekSixHomeWork {
    //最小路径和
    //自底向上
    // 1.重复性（分治）problem[i, j] = min(sub[i + 1][j], sub[i][j + 1]) + g[i][j]
    // 2.定义状态数组 f[i][j]
    // 3.dp方程  f[i][j] = Math.min(f[i + 1][j], f[i][j + 1]) + g[i][j];
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = grid;
        for (int i = rows - 1;i >= 0; --i) {
            for (int j = cols - 1; j >= 0; --j) {
                if (i != rows - 1 || j != cols - 1 ) {
                    if (i == rows - 1) dp[i][j] = dp[i][j + 1] + grid[i][j];
                    else if (j == cols - 1) dp[i][j] = dp[i + 1][j] + grid[i][j];
                    else dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
                }
            }
        }
        return dp[0][0];
    }
    //自顶向下
    // 1.重复性（分治）problem[i][j] = min(sub[i - 1][j], sub[i][j - 1]) + g[i][j]
    // 2.定义状态数组  f[i][j]
    // 3.DP方程   f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + g[i][j]
    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        int[][] dp = grid;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (i != 0 || j != 0) {
                    if (i == 0) dp[i][j] = dp[i][j - 1] + grid[i][j];
                    else if (j == 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
                    else dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
        }
        return dp[rows - 1][cols - 1];
    }

    //解码方法
    //1.重复性（分治）dp[i] = s[i] != 0 && i == 1 dp[i - 1] + 1
    //              dp[i] = s[i] != 0 && 10 <= s[i] <= 26 dp[i] + dp[i - 2]
    //2.定义状态数组 dp[i]
    //3.dp方程
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len];
        char[] c = s.toCharArray();
        if (c[0] == '0') return 0;
        dp[0] = 1;
        for (int i = 1; i < len; ++i) {
            if (c[i] != '0')
                dp[i] = dp[i - 1];
            int num = (c[i - 1] - '0') * 10 + (c[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) dp[i]++;
                else dp[i] += dp[i - 2];
            }
        }
        return dp[len - 1];
    }
    //最大正方形
    // 重复性（分治）dp[i] = i >0 && j > 0 || a[i][j] == 1 min(s[i - 1][j, s[i - 1][j - 1], s[i][j - 1]) + 1
    // 定义状态数组 dp[i][j]
    // DP方程 dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length, max = 0;
        int[][] dp = new int[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
    //矩形区域不超过 K 的最大数值和
    //前缀和 + 滑动窗口
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int rows = matrix.length, cols = matrix[0].length, res = Integer.MIN_VALUE;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (j > 0) matrix[i][j] += matrix[i][j - 1];
            }
        }
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                for (int y = j; y < cols; ++y) {
                    int max = 0;
                    for (int x = i; x < rows; ++x) {
                        if (j == 0) {
                            max += matrix[x][y];
                        }
                        else {
                            max += matrix[x][y] - matrix[x][j - 1];
                        }
                        if (max >= res && max <= k) res = max;
                    }
                }
            }
        }
        return res;
    }
}

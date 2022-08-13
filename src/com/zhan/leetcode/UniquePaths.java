package com.zhan.leetcode;

/**
 * 62. 不同路径
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 *
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 *
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 *
 * 输入：m = 3, n = 3
 * 输出：6
 *
 *
 * 提示：
 *
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 * @author ZJG
 * @version 1.0
 * @date 2022/8/12
 */
public class UniquePaths {

  static int[][] dp = new int[101][101];
  static {
    dp[1][1] = 1;
    dp[1][2] = 1;
    dp[2][1] = 1;
  }

  public static int uniquePaths(int m, int n) {
    if (m == 1 || n == 1){
      return 1;
    }
    if (dp[m][n] != 0){
      return dp[m][n];
    }
    dp[m][n - 1] = uniquePaths(m, n - 1);
    dp[m - 1][n] = uniquePaths(m - 1, n);
    return dp[m][n - 1] + dp[m - 1][n];
  }

  public static void main(String[] args) {


    int m = 3, n = 7;
//    int m = 51, n = 9;
    var uniquePaths = uniquePaths(m, n);
    System.out.println("uniquePaths = " + uniquePaths);


  }

}

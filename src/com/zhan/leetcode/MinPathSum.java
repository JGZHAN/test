package com.zhan.leetcode;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 *
 * @author ZJG
 * @version 1.0
 * @date 2022/8/12
 */
public class MinPathSum {


  public static int minPathSum(int[][] grid) {

    Integer[][] dp = new Integer[grid.length][grid[0].length];
    dp[0][0] = grid[0][0];

    return minPathSum(grid, grid.length - 1, grid[0].length - 1,dp);
  }

  public static int minPathSum(int[][] grid, int mIndex, int nIndex, Integer[][] dp) {

    if (dp[mIndex][nIndex] != null){
      return dp[mIndex][nIndex];
    }
    if (mIndex == 0){
      return grid[mIndex][nIndex] + minPathSum(grid, mIndex, nIndex - 1, dp);
    }else if (nIndex == 0){
      return grid[mIndex][nIndex] + minPathSum(grid, mIndex - 1, nIndex, dp);
    }

    if (dp[mIndex][nIndex - 1] == null){
      dp[mIndex][nIndex - 1] = minPathSum(grid, mIndex, nIndex - 1, dp);
    }
    if (dp[mIndex - 1][nIndex] == null){
      dp[mIndex - 1][nIndex] = minPathSum(grid, mIndex - 1, nIndex, dp);
    }

    return grid[mIndex][nIndex] + Math.min(dp[mIndex][nIndex - 1], dp[mIndex - 1][nIndex]);

  }

  public static void main(String[] args) {

    int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
//    int[][] grid = {{1,2},{1,1}};

    var minPathSum = minPathSum(grid);
    System.out.println("minPathSum = " + minPathSum);
  }

}

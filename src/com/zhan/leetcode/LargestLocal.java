package com.zhan.leetcode;

import java.util.Arrays;

/**
 * 6148. 矩阵中的局部最大值
 * 难度
 * 简单
 *
 * 3
 *
 * 收藏
 *
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 给你一个大小为 n x n 的整数矩阵 grid 。
 *
 * 生成一个大小为 (n - 2) x (n - 2) 的整数矩阵  maxLocal ，并满足：
 *
 * maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
 * 换句话说，我们希望找出 grid 中每个 3 x 3 矩阵中的最大值。
 *
 * 返回生成的矩阵。
 *
 *
 *
 * 示例 1：
 *
 *
 *
 * 输入：grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
 * 输出：[[9,9],[8,6]]
 * 解释：原矩阵和生成的矩阵如上图所示。
 * 注意，生成的矩阵中，每个值都对应 grid 中一个相接的 3 x 3 矩阵的最大值。
 * 示例 2：
 *
 *
 *
 * 输入：grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
 * 输出：[[2,2,2],[2,2,2],[2,2,2]]
 * 解释：注意，2 包含在 grid 中每个 3 x 3 的矩阵中。
 *
 *
 * 提示：
 *
 * n == grid.length == grid[i].length
 * 3 <= n <= 100
 * 1 <= grid[i][j] <= 100
 */
public class LargestLocal {

    public static int[][] largestLocal(int[][] grid) {

        int[][] result = new int[grid.length - 2][grid.length - 2];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                result[i][j] = getMax(i, j, grid);
            }
        }

        return result;
    }
    private static int getMax(int rowIndex, int cIndex, int[][] grif){
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result = Math.max(result, grif[rowIndex + i][cIndex + j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {

//        int[][] grid = {{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        int[][] grid = {{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}};
        int[][] largestLocal = largestLocal(grid);
        Arrays.stream(largestLocal).forEach(e->{
            Arrays.stream(e).forEach(System.out::print);
            System.out.println();
        });


    }
}

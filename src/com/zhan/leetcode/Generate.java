package com.zhan.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 *
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 *
 *
 *
 *
 * 示例 1:
 *
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 *
 * 输入: numRows = 1
 * 输出: [[1]]
 */
public class Generate {


  public static void main(String[] args) {
    int n = 5;
    var generate = generate(n);
    for (List<Integer> integers : generate) {
      for (Integer integer : integers) {
        System.out.print("," + integer);
      }
      System.out.println("");
    }
  }

  public static  List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    List first = new ArrayList<>();
    first.add(1);
    result.add(first);
    for (int i = 1; i < numRows; i++) {
      List subResult = new ArrayList<>();

      Integer cur;
      for (int j = 0; j < i + 1; j++) {
        if (j == 0 || j == i){
          cur = 1;
        }else {
          cur = result.get(i - 1).get(j - 1) + result.get(i - 1).get(j);
        }
        subResult.add(cur);
      }
      result.add(subResult);
    }

    return result;

  }
}

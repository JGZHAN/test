package com.zhan.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 难度
 * 中等
 *
 * 1751
 *
 * 收藏
 *
 * 分享
 * 切换为英文
 * 接收动态
 * 反馈
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class Subsets {


  public static List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();

    backtrackin(nums, 0, new ArrayList<>(), result);
    return result;
  }

  static void backtrackin(int[] nums, int index,List<Integer> tempResult, List<List<Integer>> result){
    result.add(List.copyOf(tempResult));
    if (index == nums.length){
      return;
    }
    for (int i = index; i < nums.length; i++) {
      tempResult.add(nums[i]);
      backtrackin(nums, i + 1, tempResult, result);
      tempResult.remove(tempResult.size() - 1);
    }
  }

  public static void main(String[] args) {

    int[] nums = {1,2,3};
    var subsets = subsets(nums);
    for (List<Integer> subset : subsets) {
      subset.forEach(System.out::print);
      System.out.println();
    }

  }
}

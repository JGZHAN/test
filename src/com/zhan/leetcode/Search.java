package com.zhan.leetcode;

/**
 * @author ZJG
 * @version 1.0
 * @date 2022/7/25
 */
public class Search {

  public static int search(int[] nums, int target) {


    int left = 0;
    int right = nums.length - 1;
    int middle = (nums.length - 1) / 2;

    while (true) {
      if (right - left == 2) {
        if (nums[left] == target) {
          return left;
        }else if (nums[right] == target) {
          return right;
        }else if (nums[middle] == target) {
          return middle;
        }
        break;
      }
      if (nums[right] < nums[middle]) {
        left = middle;
        middle = (middle + right) / 2;
      } else if (nums[middle] < nums[left]) {
        right = middle;
        middle = (middle + left) / 2;
      }
    }



    return -1;
  }

/*  public static int search(int[] nums) {

    int left = 0;
    int right = nums.length - 1;
    int middle = (nums.length - 1) / 2;

    while (true) {
      if (right - left == 1) {
        break;
      }
      if (nums[right] < nums[middle]) {
        left = middle;
        middle = (middle + right) / 2;
      } else if (nums[middle] < nums[left]) {
        right = middle;
        middle = (middle + left) / 2;
      }
    }

    return right;
  }*/

  public static void main(String[] args) {
//    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    int target = 1;
    var search = search(nums, target);
    System.out.println("search = " + search);
  }
}

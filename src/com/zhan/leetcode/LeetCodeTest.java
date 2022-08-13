package com.zhan.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LeetCodeTest {


  public int[] findOriginalArray(int[] changed) {
    var length = changed.length;
    if (changed == null || length < 2 || length % 2 != 0) {
      return new int[0];
    }
    Arrays.sort(changed);
    List<Integer> tempList = new LinkedList<>();
    for (int e : changed) {
      tempList.add(e);
    }
    int[] result = new int[length / 2];
    int point = 0;
    while (tempList.size() != 0) {
      Integer firstItem = tempList.get(0);
      Integer dubboItem = firstItem * 2;
      if (!tempList.remove(firstItem) || !tempList.remove(dubboItem)) {
        return new int[0];
      }
      result[point] = firstItem;
      point++;
    }
    return result;

  }


  public int[] findOriginalArray2(int[] changed) {
    var length = changed.length;
    if (changed == null || length < 2 || length % 2 != 0) {
      return new int[0];
    }
//    Arrays.sort(changed);
    sortLind(changed);
    List<Integer> tempList = new LinkedList<>();
    for (int e : changed) {
      tempList.add(e);
    }
    int[] result = new int[length / 2];
    int point = 0;
    while (tempList.size() != 0) {
      Integer firstItem = tempList.get(0);
      Integer dubboItem = firstItem * 2;
      if (!tempList.remove(firstItem) || !tempList.remove(dubboItem)) {
        return new int[0];
      }
      result[point] = firstItem;
      point++;
    }
    return result;

  }

  private void sortLind(int[] nums) {

    int length = nums.length;
    if (nums == null || length < 2) {
      return;
    }
    long exp = 1;
    int maxVal = Arrays.stream(nums).max().getAsInt();

    int[] tempArray = new int[length];
    while (maxVal >= exp) {
      int[] cnt = new int[10];
      for (int i = 0; i < length; i++) {
        int l = (nums[i] / (int) exp) % 10;
        cnt[l]++;
      }
      for (int i = 1; i < 10; i++) {
        cnt[i] += cnt[i - 1];
      }
      for (int i = length - 1; i >= 0; i--) {
        int l = (nums[i] / (int) exp) % 10;
        tempArray[cnt[l] - 1] = nums[i];
        cnt[l]--;
      }
      System.arraycopy(tempArray, 0, nums, 0, length);
      exp *= 10;
    }
  }


  public int[] findOriginalArray3(int[] changed) {
    var length = changed.length;
    if (changed == null || length < 2 || length % 2 != 0) {
      return new int[0];
    }
    //排序
    Arrays.sort(changed);
    //存入map
    var map = new HashMap<Integer, Integer>();
    for (int i : changed) {
      var value = map.get(i);
      if (value == null) {
        map.put(i, 1);
      } else {
        map.put(i, value + 1);
      }
    }

    int[] result = new int[length / 2];
    int point = 0;
    //map里面做查找及减少
    for (int i : changed) {

      Integer dubboItem = i * 2;
      var value = map.get(i);
      var dValue = map.get(dubboItem);

      if (i == 0 && value % 2 != 0) {
        return new int[0];
      }
      if (value == null || value == 0) {
        continue;
      } else if (dValue == null || dValue == 0) {
        return new int[0];
      } else {
        map.put(i, map.get(i) - 1);
        map.put(dubboItem, map.get(dubboItem) - 1);
        result[point] = i;
        point++;
        if (point == length / 2) {
          return result;
        }
      }

    }
    return result;

  }

  public static void main(String[] args) {
    var leetCodeTest = new LeetCodeTest();
//    int[] nums = new int[]{1,2,3,2,4,6};
//    int[] nums = new int[]{1, 1, 2, 2, 3, 6};
//    int[] nums = new int[]{0, 0, 0, 0};
    int[] nums = new int[]{0, 3, 2, 4, 6, 0};
//    int[] nums = new int[]{0, 1, 0, 0};
    var result = leetCodeTest.findOriginalArray3(nums);
    Arrays.stream(result).forEach(System.out::println);
  }
}

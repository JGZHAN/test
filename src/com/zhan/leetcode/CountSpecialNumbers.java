package com.zhan.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 2376. 统计特殊整数 如果一个正整数每一个数位都是 互不相同 的，我们称它是 特殊整数 。
 * <p>
 * 给你一个 正 整数 n ，请你返回区间 [1, n] 之间特殊整数的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 20 输出：19 解释：1 到 20 之间所有整数除了 11 以外都是特殊整数。所以总共有 19 个特殊整数。 示例 2：
 * <p>
 * 输入：n = 5 输出：5 解释：1 到 5 所有整数都是特殊整数。 示例 3：
 * <p>
 * 输入：n = 135 输出：110 解释：从 1 到 135 总共有 110 个整数是特殊整数。 不特殊的部分数字为：22 ，114 和 131 。
 */
public class CountSpecialNumbers {

/* 超时
  public static int countSpecialNumbers(int n) {

    boolean[] dp = new boolean[n + 1];
    int noCount = 0;
    for (int i = 1; i <= n; i++) {
      var hi = i / 10;
      if (dp[hi]) {
        noCount++;
        dp[i] = true;
        continue;
      }
      int temp = i;
      var set = new HashSet<Integer>();
      while (temp > 0) {
        var remainder = temp % 10;
        if (!set.add(remainder)) {
          noCount++;
          dp[i] = true;
          break;
        }
        temp /= 10;
      }

    }
    return n - noCount;
  }*/

  static int[][] dp;
  public static int countSpecialNumbers(int n) {

    var charArray = Integer.toString(n).toCharArray();

    dp = new int[charArray.length][1 << 10];

    for (int i = 0; i < charArray.length; i++) {
      Arrays.fill(dp[i], -1);
    }

    return countSpecialNumbers(charArray, 0, 0, true, false);
  }

  public static int countSpecialNumbers(char[] charArr, int index, int mask, boolean isLimit,
      boolean haveNum) {

    if (index == charArr.length) {
      return haveNum ? 1 : 0;
    }

    if (dp[index][mask] >= 0 && !isLimit && haveNum){
      return dp[index][mask];
    }

    int ans = 0;
    if (!haveNum) {
      ans = countSpecialNumbers(charArr, index + 1, mask, false, false);
    }
    int up = isLimit ? charArr[index] - '0' : 9;
    for (int i = haveNum ? 0 : 1; i <= up; i++) {
      if ((mask >> i & 1) == 0){
        ans += countSpecialNumbers(charArr, index + 1, mask | (1 << i), isLimit && i == up , true);
      }
    }
    if (!isLimit && haveNum) {
        dp[index][mask] = ans;
    }
    return ans;
  }

  public static void main(String[] args) {

//    int n = 20;
//    int n = 120;
//    int n = 187268091;
    int n = 420;
    var count = countSpecialNumbers(n);
    System.out.println("count = " + count);


  }
}

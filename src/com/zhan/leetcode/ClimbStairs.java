package com.zhan.leetcode;

public class ClimbStairs {

  public static void main(String[] args) {


    int n = 45;
    var i = climbStairs(n);
    System.out.println("i = " + i);
  }

  public static int climbStairs(int n){
    int pre = 1;
    int cur = 1;
    for (int i = 2; i <= n; i++) {
      int temp = cur;
      cur = cur + pre;
      pre = temp;
    }
    return cur;
  }

/*  static Integer[] dp = new Integer[46];
  static {
    dp[1] = 1;
    dp[2] = 2;
  }
  public static int climbStairs(int n){
    if (dp[n] != null) {
      return dp[n];
    }
    int result = climbStairs(n - 1) + climbStairs( n - 2);
    dp[n] = result;
    return result;
  }*/

}

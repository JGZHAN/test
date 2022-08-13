package com.zhan.leetcode;

public class CountBits {
  public static int[] countBitsFirst(int n) {

    int[] dp = new int[n + 1];
    dp[0] = 0;

    for (int i = 1; i <= n; i++) {
      var minQuadratic = getMinQuadratic(i);
      var subI = i & minQuadratic;
      dp[i] = 1 + dp[subI];
    }

    return dp;
  }

  private static int getMinQuadratic(int n) {
    int m = n;
    while (n > 0){
      n = n >>> 1;
      m = m | n;
    }
    m >>>= 1;
    return m;
  }



  public static int[] countBits(int n) {



    int[] dp = new int[n + 1];
    dp[0] = 0;
    int highBit = 0;
    for (int i = 1; i <= n; i++) {
      if ((i & (i - 1)) == 0) {
        highBit = i;
      }
      dp[i] = dp[i & (highBit - 1)] + 1;
    }

    return dp;
  }






  public static void main(String[] args) {
    int n = 7;
    var ints = countBits(n);
    for (int anInt : ints) {
      System.out.println("anInt = " + anInt);
    }
  }
}

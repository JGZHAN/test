package com.zhan.leetcode;

import java.util.HashMap;
import lombok.Builder;

@Builder
public class FindIntegers {
/* 超出时间范围
  public int findIntegers(int n) {

    int count = 0;
    int now = 0;
    while (now <= n){

      int tempCount = 0;
      int temp = now;
      while (temp > 0){

        if (temp % 2 == 1) {
          tempCount ++;
        }else {
          tempCount = 0;
        }
        if (tempCount == 2){
          count++;
          break;
        }
        temp = temp >>> 1;
      }
      now++;
    }
    return n - count + 1;
  }*/

  public int findIntegers(int n) {

    var minQuadratic = getMinQuadratic(n);

    int count = 0;




    return (n + 1) - count;
  }

  private static int getMinQuadratic(int n) {
    int m = n;
    while (n > 0){
      n = n >>> 1;
      m = m | n;
    }
    return m;
  }

  public static void main(String[] args) {
//    int n = 5;
    int n = 11;
    var integers = FindIntegers.builder().build().findIntegers(n);
    System.out.println("integers = " + integers);

//    new HashMap<>(11)
  }

  private static void extracted(int n) {
    int m = n;
    while (n > 0){
      n = n >>> 1;
      m = m | n;
    }
    System.out.println("m = " + m);
  }

}

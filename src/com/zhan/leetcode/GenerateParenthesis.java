package com.zhan.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 正整数 n 代表生成括号的对数，请设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *  
 *
 * 提示：
 *
 * 1 <= n <= 8
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/IDBivT
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {

  public static void main(String[] args) {
    int n = 3;
    var strings = generateParenthesis(n);
    for (String string : strings) {
      System.out.println("string = " + string);
    }
  }



  public static List<String> generateParenthesis(int n) {

    List<List<String>> dp = new ArrayList<>();
    List<String> result = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      List<String> now = new ArrayList<>();
      for (int j = 1; j <= i; j++) {
        if (i - j == 0) {
          now.add(getContStr(j));
        }else {
          for (int k = 0; k < dp.get(i - j - 1).size(); k++) {
            now.add(dp.get(j - 1).get(j - 1).concat(dp.get(i - j - 1).get(k)));
          }
          for (String s : dp.get(i - j - 1)) {
            now.add(dp.get(i - 2).get(j - 1).concat(s));
          }
        }
      }
      dp.add(now);
      result.addAll(now);
    }
    return result;
  }

  private static String getContStr(int j) {
    String temp = "";
    for (int k = 0; k < j; k++) {
      temp = temp + "(";
    }
    for (int k = 0; k < j; k++) {
      temp = temp + ")";
    }
    return temp;
  }


}

package com.zhan.leetcode;

import java.util.Stack;

/**
 * 6150. 根据模式串构造最小数字 给你下标从 0 开始、长度为 n 的字符串 pattern ，它包含两种字符，'I' 表示 上升 ，'D' 表示 下降 。
 * <p>
 * 你需要构造一个下标从 0 开始长度为 n + 1 的字符串，且它要满足以下条件：
 * <p>
 * num 包含数字 '1' 到 '9' ，其中每个数字 至多 使用一次。 如果 pattern[i] == 'I' ，那么 num[i] < num[i + 1] 。 如果 pattern[i]
 * == 'D' ，那么 num[i] > num[i + 1] 。 请你返回满足上述条件字典序 最小 的字符串 num。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：pattern = "IIIDIDDD" 输出："123549876" 解释： 下标 0 ，1 ，2 和 4 处，我们需要使 num[i] < num[i+1] 。 下标 3 ，5 ，6
 * 和 7 处，我们需要使 num[i] > num[i+1] 。 一些可能的 num 的值为 "245639871" ，"135749862" 和 "123849765" 。
 * "123549876" 是满足条件最小的数字。 注意，"123414321" 不是可行解因为数字 '1' 使用次数超过 1 次。 示例 2：
 * <p>
 * 输入：pattern = "DDD" 输出："4321" 解释： 一些可能的 num 的值为 "9876" ，"7321" 和 "8742" 。 "4321" 是满足条件最小的数字。
 */
public class SmallestNumber {


/* 自己想的传统方式
  public static String smallestNumber(String pattern) {

    var charArray = pattern.toCharArray();
    int max = 0;
    var resultArr = new int[charArray.length + 1];
    int jump = 0;
    if (charArray[0] == 'I') {
      resultArr[0] = 1;
      max = 1;
    }
    for (int i = jump; i < charArray.length; ) {
      int lon = 1;
      if (charArray[i] == 'I'){
        if (i + 1 < charArray.length && charArray[i + 1] == 'D'){
          var dlong = getDlong(charArray, resultArr, i + 1, max);
          max+=dlong + 1;
          lon += dlong;
        }else {
          resultArr[i + 1] = ++max;
        }
      }else {
        lon = getDlong(charArray, resultArr, 0, max);
        max+=lon + 1;
      }
      i += lon;
    }

    String result = "";
    for (int i : resultArr) {
      result = result + i;
    }
    return result;
  }

  private static int getDlong(char[] charArray, int[] resultArr, int index, int max) {

    int dLong = 1;
    for (int i = index + 1; i < charArray.length; i++) {
      if (charArray[i] == 'I'){
        break;
      }
      dLong++;
    }
    int min = max + 1;
    for (int i = dLong; i >= 0; i--) {
      resultArr[index + i] = min++;
    }
    return dLong;
  }
*/

  //使用栈
  public static String smallestNumber(String pattern) {
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    var toCharArray = pattern.toCharArray();
    int nowNum = 1;
    for (int i = 0; i < toCharArray.length; i++) {

      if (toCharArray[i] == 'I') {
        sb.append(nowNum);
        while (!stack.isEmpty()){
          sb.append(stack.pop());
        }
      }else {
        stack.push(nowNum);
      }
      nowNum++;
    }
    stack.push(nowNum);

    while (!stack.isEmpty()){
      sb.append(stack.pop());
    }
    return sb.toString();
  }

  public static void main(String[] args) {

    var pattern = "IIIDIDDD";
//    var pattern = "DDD";
//    var pattern = "DDDIII";

    var smallestNumber = smallestNumber(pattern);

    System.out.println("smallestNumber = " + smallestNumber);


  }
}

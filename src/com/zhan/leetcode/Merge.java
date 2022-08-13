package com.zhan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]] 输出：[[1,6],[8,10],[15,18]] 解释：区间 [1,3] 和 [2,6] 重叠,
 * 将它们合并为 [1,6]. 示例 2：
 * <p>
 * 输入：intervals = [[1,4],[4,5]] 输出：[[1,5]] 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。  
 * <p>
 * 提示：
 * <p>
 * 1 <= intervals.length <= 104 intervals[i].length == 2 0 <= starti <= endi <= 104
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode.cn/problems/merge-intervals 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author ZJG
 * @version 1.0
 * @date 2022/8/12
 */
public class Merge {

  public static int[][] merge(int[][] intervals) {

    //先排序
    Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
    List<int[]> result = new ArrayList<>();

    for (int[] interval : intervals) {

      if (result.size() != 0
          && result.get(result.size() - 1)[1] > interval[0]) {
        result.get(result.size() - 1)[1] = Math.max(interval[1], result.get(result.size() - 1)[1]);
      } else {
        result.add(interval);
      }

    }

    return result.toArray(new int[result.size()][]);
  }

  public static void merge(int[][] intervals, int[] temp, int index, List<int[]> results) {

    if (index >= intervals.length - 1) {
      results.add(temp == null ? intervals[index] : temp);
      return;
    }
    if (temp == null) {
      temp = intervals[index];
    }
    if (temp[1] >= intervals[index + 1][0]) {
      if (intervals[index + 1][1] >= temp[1]) {
        temp[1] = intervals[index + 1][1];
      }
      index++;
      merge(intervals, temp, index, results);
    } else {
      results.add(temp);
      index++;
      merge(intervals, null, index, results);
    }

  }

  public static void main(String[] args) {

//    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//    int[][] intervals = {{1,4},{4,5}};
//    int[][] intervals = {{1,4},{0,4}};
//    int[][] intervals = {{1,4},{1,4}};
//    int[][] intervals = {{1,4},{2,3}};
    int[][] intervals = {{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}};

    var merge = merge(intervals);
    for (int[] ints : merge) {
      Arrays.stream(ints).forEach(System.out::print);
      System.out.println();
    }


  }
}

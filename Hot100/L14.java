package Hot100;

import java.util.*;

public class L14 {

    public static void main(String[] args) {
        int[][] ints = merge(new int[][]{{1,4},{0,2},{3,5}});
        for (int[] anInt : ints) {
            System.out.print(Arrays.toString(anInt)+" ");
        }
    }

    public static int[][] merge(int[][] intervals) {
        // 合并重叠区间
        // [1,4] [2,3] [3,5]
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();// 记录合并后的的每一段区间
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = list.get(list.size() - 1);
            if (intervals[i][0]<=ints[1]){
                // 合并
                intervals[i][0]=ints[0];
                intervals[i][1]=Math.max(ints[1],intervals[i][1]);
                list.remove(list.size() - 1);
            }
            list.add(intervals[i]);
        }
        return list.toArray(new int[list.size()][]);
    }
}

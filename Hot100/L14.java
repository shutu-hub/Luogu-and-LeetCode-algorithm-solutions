package Hot100;

import java.util.*;

public class L14 {

    public static void main(String[] args) {
        int[][] ints = merge(new int[][]{{1,4},{4,5}});
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (merged.isEmpty() || merged.get(merged.size()-1)[1]<left){
                // 如果合并区间为空，则该区间为第一个,可直接加入 或者 该区间和下一个区间不重叠
                merged.add(new int[]{left,right});
            }else{
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],right);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}

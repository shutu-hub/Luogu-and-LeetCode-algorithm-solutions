package Hot100;

import java.util.ArrayList;
import java.util.List;

public class L19 {
    public static void main(String[] args) {
        List<Integer> list = spiralOrder(new int[][]{{1, 2, 3,4}, {5, 6,7,8}, {9,10,11,12}});
        for (Integer ele : list) {
            System.out.print(ele+" ");
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length-1;
        int right = matrix[0].length-1;
        int left = 0;
        int cur = 0;
        int maxCount = matrix.length * matrix[0].length;
        List<Integer> res = new ArrayList<>();
        while (cur<=maxCount){
            // 从左向右走
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
                cur++;
            }
            if (cur==maxCount){
                break;
            }
            top++;
            // 从上向下走
            for (int i = top; i <= bottom ; i++) {
                res.add(matrix[i][right]);
                cur++;
            }
            if (cur==maxCount){
                break;
            }
            right--;
            // 从右向左走
            for (int i = right; i >=left ; i--) {
                res.add(matrix[bottom][i]);
                cur++;
            }
            if (cur==maxCount){
                break;
            }
            bottom--;
            // 从下往上走
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
                cur++;
            }
            if (cur==maxCount){
                break;
            }
            left++;
        }
        return res;
    }
}

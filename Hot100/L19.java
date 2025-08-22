package Hot100;

import java.util.ArrayList;
import java.util.List;

public class L19 {
    public static void main(String[] args) {
        List<Integer> list = spiralOrder(new int[][]{{1, 2, 3,4}, {5, 6,7,8}, {9,10,11,12}});
        for (Integer ele : list) {
            System.out.print(ele);
        }

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int top=0;
        int bottom=matrix.length-1;
        int left=0;
        int right=matrix[0].length-1;
        ArrayList<Integer> list =new ArrayList<>();
        int maxCount=matrix.length*matrix[0].length;
        int count=0;
        while (count<maxCount){
            // 从左边到右边
            for (int i = left; i <= right ; i++) {
                list.add(matrix[top][i]);
                count++;
            }
            if (count==maxCount){
                break;
            }
            top++;
            // 从上边到下边
            for (int i = top; i <= bottom ; i++) {
                list.add(matrix[i][right]);
                count++;
            }
            if (count==maxCount){
                break;
            }
            right--;
            // 从右边到左边
            if (right>left){
                for (int i = right; i >=left ; i--) {
                    list.add(matrix[bottom][i]);
                    count++;
                }
                bottom--;
            }
          if (bottom>top){
              // 从下边到上边
              for (int i = bottom; i >=top ; i--) {
                  list.add(matrix[i][left]);
                  count++;
              }
              left++;
          }
        }
        return list;
    }
}

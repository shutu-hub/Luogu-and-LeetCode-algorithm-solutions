package Hot100;

public class L21 {

    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{5},{6}}, 6));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 从右上角开始搜索,标记当前位置为 x,y
        // 如果当前元素大于搜索元素，则当前元素所在列元素全部大于搜索元素，列-1
        // 如果当前元素小于搜索元素，则可以沿着这一列向下搜索，行+1
        int x=0,y=n-1;
        while (x<m && y>=0){
            if (matrix[x][y]==target){
                return true;
            }else if (matrix[x][y]>target){
                y--;
            }else{
                x++;
            }
        }
        return false;
    }
}

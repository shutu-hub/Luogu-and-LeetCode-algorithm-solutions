package Hot100;

public class L20 {

    public static void main(String[] args) {

    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // 顺时针旋转90°，matrix[j][n-i-1]=matrix[i][j]
        // 一次完整的旋转需要旋转四次
        /**
         * matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
         * 带入右侧对应的整体 i 和 j
         * 第一个位置为 j：n-i-1;
         * 第二个位置为 n-i-1:n-j-1;
         */
        for (int i = 0; i < n / 2; ++i) {
            for (int j = i; j < n-i-1; ++j) {
               int temp=matrix[i][j];
               matrix[i][j]=matrix[n-j-1][i];
               matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
               matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
               matrix[j][n-i-1]=temp;
            }
        }


    }
}

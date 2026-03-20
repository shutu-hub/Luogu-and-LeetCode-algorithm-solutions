package Hot100;

public class L20 {

    public static void main(String[] args) {

    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // row=col,col=n-row-1
        // 顺时针旋转90°，matrix[row][col]=matrix[n-row-1][col]
        // matrix[col][n-row-1]=martix[row][col]
        for (int i = 0; i < n/2; i++) {
            for (int j = 0; j < (n+1)/2 ; j++) {
                int temp = matrix[i][j];
                // j = n-row-1 -> row = n-j-1
                matrix[i][j]=matrix[n-j-1][i];
                // i = n-row-1
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                // n-j-1 = n-row-1
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=temp;
            }
        }
    }
}

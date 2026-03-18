package Hot100;

public class L18 {

    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        // 直接暴力修改的话是3层循环，需要降低一层循环，使用标记的方法
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==0){
                    for (int k = 0; k < matrix[i].length; k++) {
                        matrix[i][k]=0;
                    }
                    for (int k = 0; k < matrix.length; k++) {
                        matrix[k][j]=0;
                    }
                }
            }
        }
    }
}

package Hot100;

public class L64 {

    public boolean searchMatrix(int[][] matrix, int target) {
        // target小于该行最后一个数，则该数在该行的左边
        // target大于该行最后一个数，则继续向下一行找
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[i].length-1]==target){
                return true;
            }else if (matrix[i][matrix[i].length-1]>target){
                // 在该行二分查找
                return binarySearch(matrix,target,i);
            }
        }
        return false;
    }

    public boolean binarySearch(int[][] matrix,int target,int row){
        int left = 0; int right = matrix[row].length-1;
        while (left<=right){
            int mid = (left+right)>>1;
            if (matrix[row][mid]==target){
                return true;
            }else if (matrix[row][mid]>target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return false;
    }
}

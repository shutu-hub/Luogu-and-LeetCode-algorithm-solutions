package BinarySearch;
import java.io.*;


public class P2249 {

    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int m = (int) st.nval;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            array[i] = (int) st.nval;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st.nextToken();
            int pos = binarySearch(array, (int) st.nval);
            sb.append(pos).append(' ');
        }
        System.out.println(sb.toString().trim());
    }

    private static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        int index=-1;
        while (left <= right) {
            int mid = left+right>>1;
            if (array[mid] >= target) {
                right = mid-1;
                if (array[mid]==target){
                    index=mid;
                }
            } else {
                left = mid + 1;
            }
        }
        return index==-1?index:index+1;
    }
}
package LanQiaoBei.P16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class six {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n=(int)st.nval;
        int[]array=new int[n];
        int[]count=new int[(int)1e6+1];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            array[i]=(int)st.nval;
            count[array[i]]++;
        }
        long max=Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            max=Math.max(max, count[array[i]] *array[i]);
        }
        System.out.println(max);
    }
}

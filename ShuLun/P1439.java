package ShuLun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class P1439 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n=(int)st.nval;
        long result=0;
        for (int i = 0; i < n; i++) {
            st.nextToken();
           result^=(int)st.nval;
        }
        System.out.println(result);
    }
}

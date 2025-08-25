package LanQiaoBei.P16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;


public class three {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int t = (int)st.nval;
        for (int i = 0; i < t; i++) {
            st.nextToken();
            int n=(int)st.nval;
            long sum=0;
            for (int j = 0; j < n; j++) {
                st.nextToken();
                sum^=(int)st.nval;
            }
            if (sum==0){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}

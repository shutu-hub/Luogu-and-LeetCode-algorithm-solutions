package LanQiaoBei;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;

public class P13_guo_three {
    public static void main(String[] args) throws IOException {
        LinkedList<Integer>linkedList=new LinkedList<>();
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int)st.nval;
        st.nextToken();
        int m = (int)st.nval;
        for (int i = 1; i <= n; i++) {
            linkedList.add(i);
        }
        for (int i = 0; i < m; i++) {
            st.nextToken();
            String str = st.sval;
            st.nextToken();
            int num = (int) st.nval;
            linkedList.removeIf(integer -> integer == num);
            if (str.equals("L"))linkedList.addFirst(num);
            if (str.equals("R"))linkedList.addLast(num);
        }
        for (Integer integer : linkedList) {
            System.out.print(integer+" ");
        }
    }
}

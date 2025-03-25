package LanQiaoBei.P10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;


public class six {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n=(int)st.nval;
        st.nextToken();
        int m=(int)st.nval;
        st.nextToken();
        int t=(int)st.nval;
        int[][]order=new int[m+1][2];
        int[]result=new int[n+1];
        int maxTs=Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            st.nextToken();
            order[i][0]=(int)st.nval;
            maxTs=Math.max(maxTs,order[i][0]);
            st.nextToken();
            order[i][1]=(int)st.nval;
        }
        Arrays.sort(order, new Comparator<int[]>() {
            @Override
            public int compare(int[] ints, int[] t1) {
                return ints[0]-t1[0];
            }
        });
        HashSet<Integer>set=new HashSet<>();
        int beforeTs=order[1][0];
        for (int i = 1; i <= m; i++) {
            boolean[]flags=new boolean[n+1];
            int ts = order[i][0];
            int id = order[i][1];
            flags[id]=true;
            result[id]+=2;
            if (result[id]>5){
                set.add(id);
            }
            int index=i+1;
            while (index<=m && order[index][0]==ts){
                int nextId = order[index][1];
                result[nextId]+=2;
                flags[nextId]=true;
                index++;
                if (result[nextId]>5){
                    set.add(nextId);
                }
            }
            if (index<=m && order[index][0]!=ts){
                i=index-1;
            }else{
                i=index;
            }
            for (int l = 1; l < flags.length; l++) {
                if (!flags[l] && result[l]!=0){
                    result[l]=result[l]-(ts-beforeTs);
                    if (result[l]<0)result[l]=0;
                    if (result[l]<=3){
                        set.remove(l);
                    }
                }
            }
            beforeTs=ts;
        }
        int diff=t-maxTs;
        for (int i = 1; i <=n ; i++) {
           result[i]-=diff;
           if (result[i]<=3){
               set.remove(i);
           }
        }
        System.out.println(set.size());

    }
}

package LanQiaoBei.P9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.*;

public class six {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        st.nextToken();
        int d = (int) st.nval;
        st.nextToken();
        int k = (int) st.nval;
        Map<Integer,ArrayList<Integer>>map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            st.nextToken();
            int ts=(int)st.nval;
            st.nextToken();
            int id=(int)st.nval;
            if (map.containsKey(id)){
                map.get(id).add(ts);
            }else{
                // map记录的是一个个具体的时间戳
                ArrayList<Integer> list=new ArrayList<>();
                list.add(ts);
                map.put(id,list);
            }
        }
        ArrayList<Integer>set=new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
            Integer id = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            int j=0;
            Collections.sort(value);
            for (int i = 0; i < value.size(); i++) {
                while (value.get(i)-value.get(j)>=d){
                    // 时间范围大于等于D
                    j++;
                }
                if (i-j+1==k){
                    // i和j指向的是一个id的时间戳列表中的下标 i-j对应的时间戳皆为点赞的
                    set.add(id);
                    break;
                }
            }
        }
        Collections.sort(set);
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }
}

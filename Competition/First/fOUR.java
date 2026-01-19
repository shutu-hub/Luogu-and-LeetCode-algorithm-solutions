package Competition.First;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;


public class fOUR {
    public static void main(String[] args) throws IOException {
        StreamTokenizer st=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        st.nextToken();
        int n = (int) st.nval;
        int[]array=new int[n];
        for (int i = 0; i < n; i++) {
            st.nextToken();
            array[i]=((int) st.nval);
        }
        Arrays.sort(array);
        // 用一个优先级队列 用来存储每对的人数 每次拿到最少的人数
        // 拿到每个人的技能值 加入时优先加到人数最少的那组 这样就不会导致某些组人数过多
        PriorityQueue<Integer>queue=new PriorityQueue<>();
        // 先创建一个组 把技能值最小的放进去 组人数为1
        queue.offer(1);
        // 1 1 2 3 5
        for (int i = 1; i < n; i++) {
            // 从第二个人开始放
            Integer peopleNumber = queue.poll();
            if (array[i]>peopleNumber){
                // 技能值>人数 可以放
                queue.offer(peopleNumber+1);
            }else{
                // 在加一个组 人数为1
                queue.offer(1);
                queue.offer(peopleNumber);
            }
        }
        System.out.println(queue.size());

    }

}

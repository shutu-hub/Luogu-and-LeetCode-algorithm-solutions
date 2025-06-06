package TanXin;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1090 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer>queue=new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.add(scanner.nextInt());
        }
        // 每次将数量最少的两个合并
        long sum=0;
        if (queue.size()==1){
            sum=queue.poll();
        }else {
            while(queue.size()>1){
                Integer p1 = queue.poll();
                Integer p2 = queue.poll();
                int two = p1 + p2;
                queue.add(two);
                sum+=two;
            }
        }
        System.out.println(sum);
    }
}

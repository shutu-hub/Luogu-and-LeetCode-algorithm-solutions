package LanQiaoBei;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P14_eight {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][]array=new int[m][3];
        for (int i = 0; i < m; i++) {
            array[i][0]=scanner.nextInt();
            array[i][1]=scanner.nextInt();
        }
        PriorityQueue<int[]>priorityQueue=new PriorityQueue<>((ints, t1) -> 2*t1[0]*t1[2]+t1[0]+t1[1]-(2*ints[0]*ints[2]+ints[0]+ints[1]));
        for (int[] ints : array) {
            priorityQueue.offer(ints);
        }
        long total=0;
        while (n>0){
            int[] ele = priorityQueue.poll();
            int cost = 2 * ele[0] * ele[2] + ele[0] + ele[1];
            if (cost<=0){
                break;
            }
            ele[2]++;
            n--;
            priorityQueue.offer(ele);
        }
        for (int[] ints : array) {
            total += ints[2]*((long) ints[0] * ints[2] + ints[1]);
        }
        System.out.println(total);
    }


}

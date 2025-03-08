package LanQiaoBei;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 思路：
 *  题目要求n个人参与项目所花费的最大值，而每项活动的单价是随着参与人数在不断变化的，每参加一个人，都需要计算下次应该参加到哪个活动中，使该整体需要支付的最多
 *  优先级队列的排序规则，该活动加入一个人后，整体的正收益最大
 * 如果当出队的元素带来的效益为<=0时，那么说明所有活动再加入人员时不增加支出或者会减少整体支出，那么结束循环
 * 细节：
 *  k*x+b为当前活动的单个票价，(k*x+b)*x为当前支付的总价，k*(x+1)+b为加入一个人后的单个票价，
 *（k*(x+1)+b)*(x+1)为加入一个人后支付的总价
 * k*(x+1)+b)*(x+1)-(k*x+b)*x为加入一个人后带来的效益，每次出对一个带来效益最大的活动，让支付最多
 */
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

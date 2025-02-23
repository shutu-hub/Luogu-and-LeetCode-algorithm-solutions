package TanXin;
import java.util.*;

public class P1803 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        // 最先开始并且结束时间早
        int[][]array=new int[n][2];
        for (int i = 0; i < n; i++) {
            // 开始时间
            array[i][0] = scanner.nextInt();
            // 结束时间
            array[i][1] = scanner.nextInt();
        }
        // 优先选择比赛最先结束的
        Arrays.sort(array, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        /**
         *  0 1
         *  0 2
         *  1 3
         *  1 5
         *  2 6
         */
        int count=1;
        int end=array[0][1];
        for (int i = 1; i < n; i++) {
            // 下一个比赛的开始时间>=上一个活动的结束时间
            // 即从一个时间点开始选择下一个比赛 而比赛顺序是根据结束时间排的 同一个开始时间 先结束的比赛时间短
            if (array[i][0]>=end){
                count++;
                end=array[i][1];
            }
        }
        System.out.println(count);
        scanner.close();
    }
}


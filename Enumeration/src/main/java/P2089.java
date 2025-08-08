import java.util.*;
import java.util.stream.Collectors;

public class P2089 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 存放配料的
        int[]array=new int[12];
        ArrayList<List<Integer>> lists = new ArrayList<>();
        digui(1,array,n,lists);
        int right=array.length-1;
        System.out.println(lists.size());
        for (int i = 0; i < lists.size(); i++) {
            for (int j = 1; j <right ; j++) {
                System.out.print(lists.get(i).get(j)+" ");
            }
            System.out.println();
        }

    }

    public static void digui(int depth,int[] array,int n, ArrayList<List<Integer>> lists) {
        // 递归的出口 深度大于10
        if (depth>10){
            // 当深度大于10时，判断配料和是否为n
            int sum=0;
            for (int i : array) {
                sum+=i;
            }
            if (sum==n){
                // 满足 存储下
                List<Integer> collect = Arrays.stream(array).boxed().collect(Collectors.toList());
                lists.add(collect);
            }
            return;
        }
        for (int i = 1; i <=3 ; i++) {
            array[depth]=i;
            digui(depth+1,array,n,lists);
            array[depth]=0;
        }


    }
}
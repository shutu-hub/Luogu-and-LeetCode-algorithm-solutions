package Optimize;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1102 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        Map<Integer,Integer>map=new HashMap<>();
        int[]numbers=new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i]=scanner.nextInt();
            map.put( numbers[i],map.getOrDefault( numbers[i],0)+1);
        }
        long count=0;
        for (int i = 0; i < n; i++) {
            int a = numbers[i];
            int b=a-c;
            if (map.containsKey(b)){
                count+=map.get(b);
            }
        }
        System.out.println(count);
    }
}

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.ToIntFunction;

public class P2415 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = array.length;
        long sum=0;
        for (int ele : array) {
            sum+=ele*Math.pow(2,n-1);
        }
        System.out.println(sum);
    }


}

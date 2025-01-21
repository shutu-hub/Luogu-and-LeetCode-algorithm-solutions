import java.util.Scanner;

public class P1149 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array=new int[10];
        array[0]=6; array[1]=2;array[2]=5;array[3]=5;array[4]=4;array[5]=5;array[6]=6;array[7]=3;array[8]=7;array[9]=6;
        int target=n-4;
        long sum=0;
        // 1+1111=1112  8*2+2+2+5=25四位数运算时达到25根火柴
        for (int i = 0; i <= 1000; i++) {
            for (int j = i; j <= 1000; j++) {
                int numberSum=i+j;
                int count = getNum(i, array)+getNum(j, array)+getNum(numberSum, array) ;
                if (count==target){
                    if (i!=j){
                        sum+=2;
                    }else{
                        sum+=1;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    public static int getNum(int number,int[]array){
        int count=0;
        if (number==0){
            return 6;
        }
        while(number>0){
            // 不断进行拆分
            count+=array[number%10];
            number=number/10;
        }
        return count;
    }

}

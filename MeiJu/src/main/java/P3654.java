import java.util.Scanner;

public class P3654 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int R = scanner.nextInt();
        int C = scanner.nextInt();
        int K = scanner.nextInt();
        char[][] array=new char[R][C];
        for (int i = 0; i < R; i++) {
            array[i]=scanner.next().toCharArray();
        }
        long count=0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (array[i][j]=='.'){
                    int l=j+1;
                    int num=1;
                    if (K==1){
                        count++;
                        continue;
                    }
                   for (int k = 0; k < K-1 && l<C; k++, l++) {
                       if (array[i][l]!='.'){
                           break;
                       }
                       num++;
                   }
                    if (num==K){
                        count++;
                    }
               }
            }
        }
        if (K==1){
            System.out.println(count);
            return;
        }
        for (int j = 0; j < C; j++) {
            for (int i = 0; i < R; i++) {
                if (array[i][j]=='.'){
                    int l=i+1;
                    int num=1;
                    for (int k = 0; k < K-1 && l<R; k++) {
                        if (array[l][j]!='.'){
                            break;
                        }
                        num++;
                        l++;
                    }
                    if (num==K){
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}

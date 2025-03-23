package LanQiaoBei;

public class P11_three {
    public static void main(String[] args) {
        long num=2;
        long[][]array=new long[100][100];
        array[0][0]=1;
        int i=0;int j=1;
        while (true){
           if (i==0){
               while (j!=0){
                   array[i][j]=num;
                   if (i==19 && j==19){
                       System.out.println(num);
                       break;
                   }
                   i++;
                   j--;
                   num++;
               }
               array[i][j]=num;
               i++;
               num++;
           }
           if (j==0){
               while (i!=0){
                   array[i][j]=num;
                   if (i==19 && j==19){
                       System.out.println(num);
                       break;
                   }
                   i--;
                   j++;
                   num++;
               }
               array[i][j]=num;
               j++;
               num++;
           }
        }
    }
}

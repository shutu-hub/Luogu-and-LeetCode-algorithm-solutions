package LanQiaoBei.P10;

import java.util.Scanner;

public class seven {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        String str = scanner.nextLine();
        char[] chars = str.toCharArray();
        String Alice="Alice";
        long sum=0;
        // 20
        //20
        //This is a story about Alice and Bob.Alice wants to send a private message to Bob.
        for (int i = 0; i < chars.length; i++) {
                if (chars[i]=='A'){
                    int index=i+1;
                    int AliceIndex=1;
                    boolean flag=true;
                    while (index<chars.length && AliceIndex <5 ){
                        if (chars[index]==Alice.charAt(AliceIndex)){
                            index++;
                            AliceIndex++;
                        }else{
                            flag=false;
                            break;
                        }
                    }
                    if (flag){
                        // 查找K范围内Bob的个数
                        int leftCount = searchLeft(chars, i - 1, k);
                        int rightCount = searchRight(chars, index-1, k);
                        sum=sum+leftCount+rightCount;
                        i=index;
                    }
                }
        }
        System.out.println(sum);
    }

    private static int searchRight(char[] chars, int start, int k) {
        String Bob="Bob";
        int count=0;
        for (int i = start+1; i<chars.length && i<=start+k ; i++) {
            if (chars[i]=='B'){
                int index=i+1;
                int BobIndex=1;
                boolean flag=true;
                while (index<chars.length && index <=start+k+2  && BobIndex<3 ){
                    if (chars[index]==Bob.charAt(BobIndex)){
                        index++;
                        BobIndex++;
                    }else{
                        flag=false;
                        break;
                    }
                }
                if (flag && index<chars.length  && (chars[index]==' ' || chars[index]=='.')){
                    // 检测Bob单词是否独立
                    count++;
                    i=index;
                }
            }
        }
        return count;
    }

    public static int searchLeft(char[]chars,int start,int k){
        String Bob="Bob";
        int count=0;
        for (int i = start-1; i>=0 && i>=start-k; i--) {
            if (chars[i]=='b'){
                int index=i-1;
                int BobIndex=1;
                boolean flag=true;
                while (index>=0 && index >=start-k-2  && BobIndex>=0 ){
                    if (chars[index]==Bob.charAt(BobIndex)){
                            index--;
                            BobIndex--;
                    }else{
                        flag=false;
                        break;
                    }
                }
                if (flag && index>=0 && (chars[index]==' ' || chars[index]=='.')){
                    // 检测Bob单词是否独立
                   count++;
                   i=index;
                }
            }
        }
        return count;
    }
}

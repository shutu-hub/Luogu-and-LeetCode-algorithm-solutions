package LanQiaoBei.P10;

public class three {
    public static void main(String[] args) {
        long sum=0;
        for (int i = 1; i <=2019 ; i++) {
            for (int j = 1; j <=2019 ; j++) {
                for (int k = 1; k <=2019 ; k++) {
                    if (i!=j && i!=k && j!=k){
                        if (i+j+k!=2019){
                            continue;
                        }
                       if (check(i+"") && check(j+"") && check(k+"")){
//                           System.out.println(i+" "+j+" "+k);
                           sum++;
                        }
                    }
                }
            }
        }
        System.out.println(sum/6);
    }

    public static boolean check(String str){
        boolean flag=true;
        for (int l = 0; l < str.length(); l++) {
            if (str.charAt(l)=='2' || str.charAt(l)=='4'){
                flag=false;
                break;
            }
        }
        return flag;
    }
}

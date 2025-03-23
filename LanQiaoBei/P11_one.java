package LanQiaoBei;

public class P11_one {
    public static void main(String[] args) {
        long sum=0;
        for (int i = 1; i <=2020 ; i++) {
            String str=i+"";
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j)=='2'){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}

package ShuLun;

public class JinZhi {
    public static void main(String[] args) {
        String num=TenToN(10,8);
//        System.out.println(num);
        long toTen = nToTen("110", 8);
        System.out.println(toTen);
    }

    /**
     * 将十进制数num转为n进制对应的数
     * @param num
     * @param n
     * @return
     */
    private static String TenToN(long num,int n) {
        // 0101
        StringBuilder sb=new StringBuilder();
        while (num>0){
            long reminder=num%n;
            if (reminder>=10){
                sb.append((char)('A'+(reminder-10)));
            }else{
                sb.append(num%n);
            }
            num/=n;
        }
        return sb.reverse().toString();
    }

    public static long nToTen(String n,int jinzhi){
        long sum=0;
        for (int i = n.length()-1, k=0; i >= 0 ; i--,k++) {
            int c = n.charAt(i)-'0';
            long v = (long)(c * Math.pow(jinzhi, k));
            sum+=v;
        }
        return sum;
    }
}

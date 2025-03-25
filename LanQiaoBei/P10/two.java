package LanQiaoBei.P10;


public class two {
    public static void main(String[] args) {
        // 只存储后四位
        long[]array=new long[3];
        array[0]=1;
        array[1]=1;
        array[2]=1;
        int count=20190324-3;
        int index=3;
        for (int i = 0; i < count; i++) {
            array[index%3]=(array[0]+array[1]+array[2])%10000;
            index++;
        }
        System.out.println(array[(--index)%3]);
        
    }
}

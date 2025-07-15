package LanQiaoBei;

public class P13_guo_one {
    public static void main(String[] args) {
        // 6点13分22秒 14点36分20秒
        // System.out.println((14*60+36)*60+20-((6*60+13)*60+22));
       int time=0;
       double x=13;
       int y=22;
       long count=0;
       while (time<=30178){
           time++;
           y++;
           if (y>=60){
               y%=60;
               x++;
               if (x>=60)x%=60;
           }
           if (x == y)count++;
       }
       System.out.println(count);
    }
}

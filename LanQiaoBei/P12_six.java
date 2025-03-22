package LanQiaoBei;
import java.util.Scanner;

public class P12_six {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        long time=scanner.nextLong()/1000;
        long day=time%86400;
        String miao=day%60+"";
        String fen=day/60%60+"";
        String hours=day/3600%24+"";
        if (miao.length()<2)miao="0"+miao;
        if (fen.length()<2)fen="0"+fen;
        if (hours.length()<2)hours="0"+hours;
        System.out.println(hours+":"+fen+":"+miao);
    }
}

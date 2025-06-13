package LanQiaoBei.P16;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class five {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n = scanner.nextInt();
        Area[] areas=new Area[n];
        for (int i = 0; i < n; i++) {
                int x=scanner.nextInt();
                int y=scanner.nextInt();
                int r=scanner.nextInt();
                Area area=new Area(x,y,r);
                areas[i]=area;
        }
        int[]fa=new int[n];
        for (int i = 0; i < fa.length; i++) {
            fa[i]=i;
        }
        // i,j,dis
        PriorityQueue<double[]>queue=new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] doubles, double[] t1) {
                return Double.compare(doubles[2],t1[2]);
            }
        });
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n ; j++) {
                Area one = areas[i];
                Area two = areas[j];
                double dis=Math.sqrt(Math.pow(one.x-two.x,2)+Math.pow(one.y-two.y,2));
                if (dis<=one.r+two.r){
                    int fai = find(fa, i);
                    int faj = find(fa, j);
                    if (fai!=faj){
                        fa[fai]=faj;
                    }
                }else{
                    queue.add(new double[]{i,j,dis-one.r- two.r});
                }
            }
        }
        double sum=0;
        while (!queue.isEmpty()){
            double[] poll = queue.poll();
            int one = (int) poll[0];
            int two = (int) poll[1];
            double dis = poll[2];
            int fai = find(fa, one);
            int faj = find(fa, two);
            if (fai==faj){
                continue;
            }
            fa[fai]=faj;
            sum+=dis;
        }
        System.out.printf("%.2f",sum);
    }

    public static int find(int[]fa,int x){
        if (fa[x]!=x){
            fa[x]=find(fa,fa[x]);
        }
        return fa[x];
    }
}

class Area{
    int x;
    int y;
    int r;
    public Area(int x, int y, int r) {
        this.x=x;
        this.y=y;
        this.r=r;
    }
}

package QianZhuiHe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P1496 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Segment> segments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            segments.add(new Segment(a, b));
        }

        // 按照起点排序，如果起点相同，则按终点排序
        Collections.sort(segments);

        if (segments.isEmpty()) {
            System.out.println(0);
            return;
        }

        int totalLength = 0;
        Segment currentSegment = segments.get(0);

        for (int i = 1; i < segments.size(); i++) {
            Segment nextSegment = segments.get(i);
            if (nextSegment.start <= currentSegment.end) {
                // 合并线段
                currentSegment.end = Math.max(currentSegment.end, nextSegment.end);
            } else {
                totalLength += (currentSegment.end - currentSegment.start);
                currentSegment = nextSegment;
            }
        }

        // 添加最后一组合并后的长度
        totalLength += (currentSegment.end - currentSegment.start);

        System.out.println(totalLength);
    }

    // 自定义的线段类，实现了比较器以进行排序
    public static class Segment implements Comparable<Segment> {
        int start;
        int end;

        public Segment(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Segment other) {
            if (this.start != other.start) {
                return Integer.compare(this.start, other.start);
            } else {
                return Integer.compare(this.end, other.end);
            }
        }
    }
}

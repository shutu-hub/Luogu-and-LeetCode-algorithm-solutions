package Hot100;

import java.util.ArrayList;
import java.util.LinkedList;

public class L53 {
    public static void main(String[] args) {
        boolean b = canFinish(2, new int[][]{{1,0}});
        System.out.println(b);
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1 统计每个课程的入度
        // 存放每个课程的后继课程，该课程学完后，遍历该课程的后继课程依次-1即可
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        int[] preNum = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            preNum[prerequisite[0]]++;
            graph[prerequisite[1]].add(prerequisite[0]);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        // 2 入度为 0 的课程进入队列
        for (int i = 0; i < preNum.length; i++) {
            if (preNum[i]==0){
                queue.offer(i);
            }
        }
        // 3 从队列中取出入度为 0 的课程，并减去对应的课程的入度，再判断对应课程入度是否为 0，为 0 则入队
        int outSize=0;
        while (!queue.isEmpty()){
            // 这个课程学习了，它对应课程的入度--
            Integer poll = queue.poll();
            outSize++;
            for (Integer houJiCourse : graph[poll]) {
                preNum[houJiCourse]--;
                if (preNum[houJiCourse]==0){
                    queue.offer(houJiCourse);
                }
            }
        }
        return outSize==numCourses;
    }
}

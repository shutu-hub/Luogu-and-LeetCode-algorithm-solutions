package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L62 {

    boolean[]dx;
    boolean[]dy;
    boolean[]youxia;
    boolean[]youshang;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        String[][] array = new String[n][n];
        for (String[] strings : array) {
            Arrays.fill(strings,".");
        }
        dx=new boolean[n];
        dy=new boolean[n];
        youxia=new boolean[2*n];
        youshang=new boolean[2*n];
        digui(array,0,new ArrayList<>());
        return res;
    }

    public void digui(String[][]array,int index,ArrayList<String> list){
        if (index>=array.length){
            // 记录满足条件的解
            for (String[] strings : array) {
                StringBuilder sb = new StringBuilder();
                for (String str : strings) {
                    if (str.equals("Q")) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            res.add(new ArrayList<>(list));
            // 这里list记录了之前的解，如果不清空，list会重复
            list.clear();
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (!dx[index] && !dy[i] && !youxia[i-index+array.length] && !youshang[i+index]){
                // 这个点可以被标记
                array[index][i]="Q";
                dx[index]=true;
                dy[i]=true;
                youxia[i-index+array.length]=true;
                youshang[i+index]=true;
                digui(array,index+1,list);
                // 记得回退某个点的状态
                array[index][i]=".";
                dx[index]=false;
                dy[i]=false;
                youxia[i-index+array.length]=false;
                youshang[i+index]=false;
            }
        }
    }

}

package Hot100;

import java.util.ArrayList;
import java.util.List;

public class L58 {

    List<ArrayList<Integer>> lists;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 每一层可以选择n个元素
        lists = new ArrayList<>();
        digui(candidates,target,0,1,new ArrayList<>(),0);
        return new ArrayList<>(lists);
    }

    public void digui(int[] candidates, int target,int cur,int index,List<Integer> list,int start){
        if (cur>target){
            return;
        }
        // 从start开始，可以避免出现重复组合
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            if (cur+candidates[i]==target){
                lists.add(new ArrayList<>(list));
                list.remove(index-1);
                continue;
            }
            // 下一个start为i，则candidates[i]可以使用多次
            digui(candidates,target,cur+candidates[i],index+1,list,i);
            list.remove(index-1);
        }
    }
}

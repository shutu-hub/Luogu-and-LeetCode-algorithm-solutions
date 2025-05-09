package SouSuo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode79 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsets(int[] nums) {
            // 一次深搜枚举所有子集 组合
        List<List<Integer>> lists=new ArrayList<>();
        for (int i = 1; i <= nums.length ; i++) {
            dfs(nums,0,i,0,new ArrayList<>(),lists);
        }
        lists.add(new ArrayList<>());
        return lists;
    }

    public static void dfs(int[] nums,int index,int size,int start,ArrayList<Integer> list,List<List<Integer>> lists){
        if (index>=size){
            // 已经生成该size的子集
            lists.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums,index+1,size,i+1,list,lists);
            list.remove(list.size()-1);
        }
    }
}

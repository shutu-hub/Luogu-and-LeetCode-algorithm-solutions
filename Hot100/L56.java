package Hot100;

import java.util.ArrayList;
import java.util.List;

public class L56 {

   static List<List<Integer>> lists;

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
        for (List<Integer> list : subsets) {
            System.out.println(list);
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        // 一次深搜枚举所有子集
        lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        digui(nums,new ArrayList<>(),1,0);
        return lists;
    }

    private static void digui(int[] nums, ArrayList<Integer> list,int index,int start) {
        if (index>nums.length){
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            lists.add(new ArrayList<>(list));
            digui(nums,list,index+1,i+1);
            list.remove(index-1);
        }
    }
}

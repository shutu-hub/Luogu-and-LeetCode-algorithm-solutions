package review;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class P2089 {
	public static ArrayList<LinkedList<Integer>> lists ;
	
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		int n=scanner.nextInt();
		lists =new ArrayList<>();
		LinkedList<Integer> list=new LinkedList<>();
		dfs(1,n,0,list);
		System.out.println(lists.size());
		for (int i = 0;i<lists.size();i++) {
			LinkedList<Integer> numbers=lists.get(i);
			for (int j = numbers.size()-1; j >=0; j--) {
				System.out.print(numbers.get(j)+" ");
			}
			System.out.println();
		}
	}
	
	public static void dfs(int index,int n,int total,LinkedList<Integer> list) {
		if (index>10) {
			if (total==n) {
				lists.add(new LinkedList<Integer>(list));
			}
			return;
		}
		for (int i = 1; i <= 3; i++) {
			list.push(i);
			dfs(index+1,n,total+i,list);
			list.poll();
		}
	}
}

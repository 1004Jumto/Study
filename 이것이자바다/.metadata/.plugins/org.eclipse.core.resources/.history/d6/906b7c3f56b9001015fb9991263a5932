package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {

	public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		List<List<Integer>> ans = new ArrayList<>();
		ans.add(new ArrayList<Integer>());
		ans.add(new ArrayList<Integer>());
		HashSet<Integer> hs1 = new HashSet<>();
		HashSet<Integer> hs2 = new HashSet<>();

		for(int i : nums1) hs1.add(i);
		for(int i : nums2) hs2.add(i);
			
		for(int i : hs2) {
			if(!hs1.contains(i)) ans.get(1).add(i);
		} 
		
		for(int i : hs1) {
			if(!hs2.contains(i)) ans.get(0).add(i);
		}
		return ans;

	}
	
	public boolean uniqueOccurrences(int[] arr) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		HashSet<Integer> hs = new HashSet<>();
		for(int i : arr) {
			hs.add(i);
		}
		
		
		return false;
    }

	public static void main(String[] args) {
		System.out.println(findDifference(new int[] {1,2,3}, new int[] {2,4,6}));
		 
	}

}

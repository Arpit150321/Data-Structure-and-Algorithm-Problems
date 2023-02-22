package Leetcode.Sorting.Essay;

import java.util.ArrayList;

public class Solution {

    //349
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]){
                    if(!nums.contains(nums1[i])){
                        nums.add(nums1[i]);
                    }
                }
            }
        }
        int[] num = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            num[i] = nums.get(i);
        }
        return num;
    }
}

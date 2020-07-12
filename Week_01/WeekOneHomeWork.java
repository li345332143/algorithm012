package org.example;


import java.util.*;

public class WeekOneHomeWork {
    //两数之和
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp) && map.get(tmp) != i){
                return new int[]{map.get(tmp), i};
            }
            else {
                map.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException();
    }
    //旋转数组
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = 0;
        for (int i = 0; count < n; i++) {
            int first = i;
            int prev = nums[i];
            do {
                int next = (k + first) % n;
                int tmp = nums[next];
                nums[next] = prev;
                prev = tmp;
                first = next;
                count++;
            }
            while (i != first);
        }
    }
    //合并两个有序数列
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
    //移动零
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) nums[i] = 0;
                ++j;
            }
        }
    }
    //删除排序数组中的重复项
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; ++j) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }



}

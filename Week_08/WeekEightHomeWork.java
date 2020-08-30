package org.example;

public class WeekEightHomeWork {
    //数组的相对排序
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int count[] = new int[1001];
        for (int i : arr1) count[i]++;
        int index = 0;
        for (int i : arr2) {
            while (count[i] > 0) {
                arr1[index++] = i;
                count[i]--;
            }
        }
        for (int i = 0; i < count.length; ++i) {
            while (count[i] > 0) {
                arr1[index++] = i;
                count[i]--;
            }
        }
        return arr1;
    }
    //242. 有效的字母异位词
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
            if (count[c - 'a'] < 0) return false;
        }
        return true;
    }
    //190. 颠倒二进制位
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; ++i) {
            res = (res << 1) + (n & 1);
            n >>= 1;
        }
        return res;
    }
    //191. 位1的个数
    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            n &= (n - 1);
            sum++;
        }
        return sum;
    }
    //231. 2的幂
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        return ((long)n & ((long)n - 1)) == 0;
    }

    //冒泡 2,3,1,6,5,9,7,8
    public static int[] bubbleSort(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - 1 - i; ++j) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }
    //选择排序
    public static int[] selectionSort(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int n = nums.length;
        int minIndex,tmp;
        for (int i = 0; i < n - 1; ++i) {
            minIndex = i;
            for (int j = i + 1; j < n; ++j) if (nums[minIndex] > nums[j]) minIndex = j;
            tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;
        }
        return nums;
    }
    //插入排序
    public static int[] insertionSort(int[] nums) {
        if (nums == null || nums.length == 0) return nums;
        int n = nums.length;
        int preIndex, curr;
        for (int i = 1; i < n; ++i) {
            preIndex = i - 1;
            curr = nums[i];
            while (preIndex >= 0 && nums[preIndex] > curr) nums[preIndex + 1] = nums[preIndex--];
            nums[preIndex + 1] = curr;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{9,8,7,6,5,4,3,2,1};
        insertionSort(nums);
    }

}

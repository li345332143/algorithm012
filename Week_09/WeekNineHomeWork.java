package org.example;

import java.util.Arrays;
import java.util.Stack;

public class WeekNineHomeWork {
    //387. 字符串中的第一个唯一字符
    public int firstUniqChar(String s) {
        int count[] = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        for (int i = 0; i < s.length(); ++i) if (count[s.charAt(i) - 'a'] == 1) return i;
        return -1;
    }
    //680. 验证回文字符串 Ⅱ
    public boolean validPalindrome(String s) {
        return validPalindrome(s, 0, s.length() - 1, 1);
    }
    private boolean validPalindrome(String s, int i, int j, int vCount) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (vCount == 0) return false;
                return validPalindrome(s, i + 1, j, vCount - 1) || validPalindrome(s, i, j - 1, vCount - 1);
            }
            i++;
            j--;
        }
        return true;
    }
    //300. 最长上升子序列
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, res = 1;
        if (n < 2) return n;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    //91. 解码方法
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int len = s.length();
        int[] dp = new int[len];
        char[] c = s.toCharArray();
        if (c[0] == '0') return 0;
        dp[0] = 1;
        for (int i = 1; i < len; ++i) {
            if (c[i] != '0')
                dp[i] = dp[i - 1];
            int num = (c[i - 1] - '0') * 10 + (c[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) dp[i]++;
                else dp[i] += dp[i - 2];
            }
        }
        return dp[len - 1];
    }
    //32. 最长有效括号
    public int longestValidParentheses(String s) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if(stack.empty()) stack.push(i);
                else res = Math.max(res, i - stack.peek());
            }
        }
        return res;
    }
}

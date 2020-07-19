package org.example;

import java.util.*;

public class WeekTwotHomeWork{
    //两数之和 target = a + b
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp) && map.get(tmp) != i) {
                return new int[]{map.get(tmp), i};
            }
            else {
                map.put(nums[i],i);
            }
        }
        throw new IllegalArgumentException("");
    }
    //N叉树前序遍历
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    //迭代
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            for (int i = node.children.size() - 1; i >= 0 ; --i) {
                stack.push(node.children.get(i));
            }
        }
        return res;
    }
    //递归
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder2(Node root) {
        dfs(root);
        return res;
    }
    public void dfs (Node root) {
        if (root == null) return;
        res.add(root.val);
        for (Node child : root.children) {
            dfs(child);
        }
    }
    //有效的字母异位词
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int arr[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            arr[t.charAt(i) - 'a']--;
            if (arr[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }



}

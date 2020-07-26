package org.example;

import java.util.*;

public class WeekThreetHomeWork {
    //236. 二叉树的最近公共祖先
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }
    //78. 子集
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsetsDfs(res, nums, 0, new ArrayList<Integer>());
        return res;
    }
    public void  subsetsDfs (List<List<Integer>> res, int[] nums, int count, List<Integer> list) {
        if (count == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        subsetsDfs(res, nums, count + 1, list);
        list.add(nums[count]);
        subsetsDfs(res, nums, count + 1, list);
        list.remove(list.size() - 1);
    }
    //105. 从前序与中序遍历序列构造二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            map.put(inorder[i], i);
        }
        return  buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length,map);
    }
    //p: 3,  9  ,20,15,7
    //i: 9,  3  ,15,20,7
    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end, Map<Integer, Integer> map) {
        if (p_start == p_end) return null;
        int root_val = preorder[p_start];
        int i_root_index = map.get(root_val);
        int left_num = i_root_index - i_start;
        TreeNode root = new TreeNode(root_val);
        root.left = buildTreeHelper(preorder, p_start + 1, p_start + left_num + 1, inorder, i_start, i_root_index, map);
        root.right = buildTreeHelper(preorder, p_start + left_num + 1, p_end, inorder, i_root_index + 1, i_end, map);
        return root;
    }
    //77. 组合
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        backtrack(n, k , 1, new LinkedList<Integer>(), res);
        return res;
    }

    private void backtrack(int n, int k, int first, LinkedList<Integer> curr, List<List<Integer>> res) {
        if (curr.size() == k) res.add(new LinkedList<>(curr));
        for (int i = first; i <= n; ++i) {
            curr.add(i);
            backtrack(n, k, i + 1, curr, res);
            curr.removeLast();
        }
    }

}

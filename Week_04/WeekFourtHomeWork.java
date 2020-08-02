package org.example;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class WeekFourtHomeWork {
    public class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    //深度优先模板 102. 二叉树的层序遍历
    public List<List<Integer>> levelOrderDfs(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, 0, res);
        return res;
    }
    private void dfs(TreeNode root, int level, List<List<Integer>> res) {
        if (level == res.size()) res.add(new ArrayList<Integer>());
        res.get(level).add(root.val);
        if (root.left != null)
            dfs(root.left, level + 1, res);
        if (root.right != null)
            dfs(root.right, level + 1, res);
    }
    //广度优先优先模板   102. 二叉树的层序遍历
    public List<List<Integer>> levelOderBfs(TreeNode root) {
        List<List<Integer>> allRes = new ArrayList<>();
        if (root == null) return allRes;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        while (!deque.isEmpty()) {
            List<Integer> res = new ArrayList<>();
            int size = deque.size();
            for (int i = 0; i < size; ++i) {
                TreeNode tmp = deque.pollLast();
                res.add(tmp.val);
                if (tmp.left != null) {
                    deque.addFirst(tmp.left);
                }
                if (tmp.right != null) {
                    deque.addFirst(tmp.right);
                }
            }
            allRes.add(res);
        }
        return allRes;
    }
    //柠檬水找零
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        int n = bills.length;
        for (int num : bills) {
            if (num == 5) {
                five++;
            }
            else if (num == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            }
            else if (num == 20) {
                if (five > 0 && ten > 0) {
                    five--;
                    ten--;
                }
                else if (five > 2) {
                    five -= 3;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
    //122. 买卖股票的最佳时机 II
    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            max += prices[i] > prices[i - 1] ? prices[i] - prices[i - 1] : 0;
        }
        return max;
    }
    //200. 岛屿数量
    private static final int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private boolean[][] marked;
    private int rows;
    private int cols;
    private char[][] grid;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        this.grid = grid;
        marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }
        return count;
    }
    private void dfs(int i, int j) {
        marked[i][j] = true;
        for (int k = 0; k < 4; ++k) {
            int X = i + directions[k][0];
            int Y = j + directions[k][1];
            if (inArea(X, Y) && grid[X][Y] == '1' && !marked[X][Y]) {
                dfs(X, Y);
            }
        }
    }
    private boolean inArea (int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}

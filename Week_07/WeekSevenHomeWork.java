package org.example;

import java.util.*;

public class WeekSevenHomeWork {
    //爬楼梯
    public int climbStairs(int n) {
        int f1 = 0, f2 = 0, f3 = 1;
        for (int i = 0; i < n; ++i) {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
        }
        return f3;
    }
    //岛屿数量
    private int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] marked;
    private int rows,cols;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        rows = grid.length;
        cols = grid[0].length;
        marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < rows; ++j) {
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }
    private void dfs(int i, int j, char[][] grid){
        marked[i][j] = true;
        for (int k = 0; k < 4; ++k) {
            int x = i + directions[k][0];
            int y = j + directions[k][1];
            if (isArea(x, y) && !marked[x][y] && grid[x][y] == '1') {
                dfs(x, y, grid);
            }
        }
    }
    private boolean isArea(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y <cols;
    }
    //被围绕的区域
    //private int rows,cols;
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        rows = board.length;
        cols = board[0].length;
        for (int i = 0; i < rows; ++i) {
            dfs(board,i, 0);
            dfs(board,i, cols - 1);
        }
        for (int j = 0; j < cols; ++j) {
            dfs(board, 0, j);
            dfs(board, rows - 1, j);
        }
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                if (board[i][j] == 'A') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }
    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x == rows || y == cols || board[x][y] != 'O') return;
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }
    //单词接龙
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        boolean[] visited = new boolean[wordList.size()];
        int index = wordList.indexOf(beginWord);
        if (index != -1) visited[index] = true;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            count++;
            while (size-- > 0) {
                String start = queue.poll();
                for (int i = 0; i < wordList.size(); ++i) {
                    String s = wordList.get(i);
                    if (visited[i] || !containsStr(start, s)) continue;
                    if (endWord.equals(s)) return ++count;
                    visited[i] = true;
                    queue.add(s);
                }
            }
        }
        return 0;
    }
    private boolean containsStr(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int count = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
            if (count > 1) return false;
        }
        return 1 == count;
    }
    //最小基因变化
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> bank_library = new HashSet<>();
        for (String library : bank) {
            bank_library.add(library);
        }
        char[] banks = {'A', 'C', 'G', 'T'};
        LinkedList<String> dequeue = new LinkedList<>();
        dequeue.offer(start);
        int count = 0;
        HashSet<String> visited = new HashSet<>();
        while (!dequeue.isEmpty()) {
            int size = dequeue.size();
            while (size-- > 0) {
                String poll = dequeue.poll();
                if (poll.equals(end)) return count;
                char[] curr = poll.toCharArray();
                for (int i = 0; i < curr.length; i++) {
                    char old = curr[i];
                    for (char b : banks) {
                        curr[i] = b;
                        String newString = new String(curr);
                        if (!visited.contains(newString) && bank_library.contains(newString)) {
                            visited.add(newString);
                            dequeue.offer(newString);
                        }
                    }
                    curr[i] = old;
                }
            }
            count++;
        }
        return -1;
    }
    //生成括号
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        bfs(n, 1, 0, "(");
        return res;
    }
    void bfs(int n, int left, int right, String str) {
        if (str.length() >= n * 2) {
            res.add(str);
            return;
        }
        if (left < n) {
            bfs(n, left + 1, right, str + "(");
        }
        if (right < left) {
            bfs(n, left, right + 1, str + ")");
        }

    }

}

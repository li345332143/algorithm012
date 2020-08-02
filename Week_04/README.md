1.深度优先搜索和广度优先搜索
DFS模板代码
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
BFS模板代码
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

2.T贪心算法Greedy
贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（最有利）的选择，从而希望结果是全局最好或者最优的算法。
贪心算法和动态规划的不同在于他对每个子问题的解决方案都做出选择，不能回退。动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。
贪心：当下做局部最优判断
回溯：能够回退
动态规划：最有判断+回退
贪心法可以解决一些最优化问题，如求图中的最小生成树，求哈夫曼编码等。然后对于工程和生活中的问题，贪心法一般不能得到我们所要的答案。
一旦一个问题可以通过贪心法来解决，那么贪心法一般是解决这个问题的最好办法。由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心法也可以作用做辅助算法或者直接解决一些要求结果不特别精准的问题。
3.二分查找
目标函数单调性（单调递增或者递减）
存在上下界
能够通过索引访问（有序的）
二分查找模板
	public int binarySearch(int[] array, int target) {
int left = 0, right = array.length - 1, mid;
while (left <= right) {
mid = (right - left) / 2 + left;

if (array[mid] == target) {
return mid;
} else if (array[mid] > target) {
right = mid - 1;
} else {
left = mid + 1;
}
}

return -1;
}


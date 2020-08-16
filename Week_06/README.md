1.动态规划
动态规划和递归或者分治没有根本上的区别（关键看有无最优的子结构）
共性：找到重复子问题
差异性：最优子结构，中途可以淘汰次最优解
动态规划关键点
(1)最优子结构
(2)存储中间状态
(3)递推公式(DP方程 )	
思维小结：
(1)打破自己的思维惯性，形成机器思维
(2)理解复杂逻辑的关键
(3)也是职业进阶的要点要领
MIT课程动态规划的关键点
(1)分治，复杂问题转化简单的子问题
(2)猜递推方程
(3)子问题的解合并
(4)递推记忆化
递归模板
public void recur(int level, int param) {
    // terminator 
    if (level > MAX_LEVEL) {
        // process result 
        return;
    }
    // process current logic 
    process(level, param);
    // drill down 
    recur( level: level + 1, newParam);
    // restore current status 
}
分治模板
private static int divide_conquer(Problem problem, ) {
    if (problem == NULL) {
        int res = process_last_result();
        return res;
    }
    subProblems = split_problem(problem)

    res0 = divide_conquer(subProblems[0])
    res1 = divide_conquer(subProblems[1])

    result = process_result(res0, res1);

    return result;
}



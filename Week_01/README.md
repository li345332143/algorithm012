复杂度分析
一．时间复杂度
O（1）常数复杂度
O（log n）对数复杂度 二分查找
O（n）线性时间复杂度 单个循环
O（n^2）平方 两层嵌套循环
O（n^3）立方 三层嵌套循环
O（2^n）指数 一般常见递归
O（n！）阶乘
时间复杂度简单理解就是N执行的次数
二．空间复杂度
常数级
数组长度
递归深度

三．数组，链表，跳表	
数组：一种线性数据结构，用一组连续的内存空间，
查询修改O（1）新增和删除O（n）
数组长度不够，会从新new一个新的长度为原来数组长度二倍的数组	
 	链表：由一个个节点连接在一起，如果只有next指针是单链表，如果有head指针就是双向链表，如果next指针指向head就是循环链表
  访问O（n）新增删除O（1）
跳表：要快速查询可以进行升维（链表是有序的），跳表对标的是平衡树（AVL tree）和二分查找是一种插入删除搜索都是O（n），是用来取代平衡树和二分查找
四．栈和队列
栈（stack）：先入后出，添加删除O（1）查询O（n）
现实中推荐用Deque

双端队列(Deque)：头尾都可以进行元素的入和出 添加删除O（1）查询O（n）

优先队列（Priority Queue）: 插入O（1）取出O（logN）按照优先级取出

队列(queue)：先入先出，添加删除O（1）查询O（n）底层具体实现的数据结构较为多样和复杂heap,bst,treap

五．查找API 直接搜stack java 10 queue java 10等
六．源代码搜索 source stack java


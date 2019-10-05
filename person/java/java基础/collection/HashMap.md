基于jdk8
数组(Node[] table) + 链表(Node)或者红黑树(TreeNode)
TreeNode是Node子类，可以强制类型转换

默认大小16, 负载因子0.75，表长为2的整数幂

哈希算法(null放在0)
hash = ((h = hashcode) ^ h >>> 16)
pos = hash & (n - 1)
put
如果table
先获取key的hash值,就是在表中的桶位置，如果桶为null，先new Node,

####java运行的参数配置
    -Xms初始堆大小 
    -Xmx最大堆大小 
    -Xss线程栈大小

####应用可达算法
GC Roots遍历

####新生代
复制算法

####老年代
标记清理

####CMS (UseCMSCompactAsFullCollection) 
1. 初始标记 
2. 并发标记 
3. 最终标记 
4. 筛选回收

标记整理
G1 (优先队列)
ZGC
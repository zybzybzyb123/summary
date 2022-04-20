####java运行的参数配置
    -Xmn 设置年轻代大小
    -XX:NewSize 设置新生代最小空间大小
    -XX:MaxNewSize 设置新生代最大空间大小
    -Xms初始堆大小 
    -Xmx最大堆大小 
    -Xss线程栈大小
    -XX:NewRatio 新生代和老年代比例 默认1:2
    -XX:+HeapDumpOnOutOfMemoryError 内存溢出dump 
    -XX:HeapDumpPath=/home/zero/config/idea/dump
    -verbose:gc 打印gc日志
    

####应用可达算法
    GC Roots遍历
        栈上的对象, 静态变量, 常量
####新生代
    复制算法
        eden区空间不够就触发min gc, eden + from_survivor + to_survivor
####老年代
    1. 标记清理
        CMS (UseCMSCompactAsFullCollection)
        响应时间优先, 比较占用cpu资源, 会产生内存碎片,存在浮动垃圾 
            1. 初始标记 (stw) 
            2. 并发标记 
            3. 最终标记 (stw)
            4. 筛选回收
            
    2. 标记整理
        G1 (优先队列)
        可预测响应时间的垃圾收集器
        ZGC
#### java锁的常见问题
    
    1. synchonized 和 Lock的区别
        synchonized虚拟机层面的锁, 可以锁普通方法(this对象),
        静态方法(class对象),代码块(指定的对象), 1.6以后实现了锁粗化优化
        lock底层原理是aqs, 需要显示的释放锁, 提供超时,可中断
        
    
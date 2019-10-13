加载
链接 (验证准备解析)
初始化
使用
卸载

双亲委派模型,子类通过组合调用父类加载器
bootstrap classloader(根加载器)
extention classloader(额外加载器)
application classloader(应用加载器)

自定义的类加载器继承应用类加载器

OSGI 同层之间可以依赖类加载器
JNI破坏双亲委派模型 jdbc实现
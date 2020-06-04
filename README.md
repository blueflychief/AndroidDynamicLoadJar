# Apk运行时加载Jar包中的Class


### 1、创建需要放入到Jar包中的类
com.infinite.dynamicloadjar.plugin.PluginLoader

com.infinite.dynamicloadjar.plugin.CountryBean

### 2、在app的build.gradle中添加生成Jar包的task
```
task deleteOldJar(type: Delete) {
    delete 'build/libs/loadJar.jar'
}
//打包操作
task makePluginJar(type: Jar) {
    //要打成的包的名字
    baseName 'loadJar'
    //选取要打包的文件夹
    from('build/intermediates/javac/debug/classes/com/infinite/dynamicloadjar/plugin/')
    //需要跟实际类的包名路径一样
    into('com/infinite/dynamicloadjar/plugin')
//    排除在外的文件
//    exclude('BuildConfig.class', 'R.class', 'MainActivity.class')
//    排除以R$开头的文件
//    exclude{ it.name.startsWith('R$');}
}
//打包,在右侧边栏中Gradle-->app-->other-->makePluginJar
//最后在build/libs/文件夹下执行命令,loadJar1.jar是生成的文件
// dx --dex --output=loadJar1.jar loadJar.jar
makePluginJar.dependsOn(deleteOldJar, build)
```

### 3、转换Jar包
在右侧边栏中Gradle-->app-->other-->makePluginJar运行任务后会在app/build/libs目录下生成loadJar.jar，

然后使用dx命令转换Jar包，dx工具位于/Users/xxxx/AndroidSDK/build-tools/28.0.3下，可配置到系统环境变量中

运行dx命令，loadJar1.jar是转换后的Jar文件
```
dx --dex --output=loadJar1.jar loadJar.jar
```
将loadJar1.jar拷贝到手机SD卡中的amap目录下

### 4、运行时加载loadJar1.jar见MainActivity，
记得给SD卡读写权限，将这两个类注释掉，运行时不需要了
```
com.infinite.dynamicloadjar.plugin.PluginLoader
com.infinite.dynamicloadjar.plugin.CountryBean
```
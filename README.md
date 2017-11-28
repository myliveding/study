# Study
Java Study Something

# 项目
纯后台接口项目--简介如下：

#### 技术
动态数据源
redis
mq
excel导入


##### 项目种类
动态数据源一个
纯后台一个配置单数据源--swagger2
jsp一个加微信分享支付环境得代码
html一个加微信分享支付环境得代码
其他得就是各个项目得了


# mybatis的逆向工程

##### 1. 使用的是配置文件的形式

ps: war打包时不能使用插件形式（打包时需要把逆向工程的插件注释掉，
否则会重新執行逆向工程把你的代码覆盖），使用Lifecycle去打包

##### 2. MybatisCodeHelper

这个插件已经收费了，自己使用的都是老的版本，需要手工导入包和编译文件
（一般idea插件路径：C:\Users\Administrator\.IntelliJIdea2017.2\config\plugins）
插件包位置我放在百度云了


# thymeleaf
##### 1. 自动部署加载
spring.thymeleaf.cache=false
如果使用的开发工具是idea,修改html后使用Ctrl+Shift+F9
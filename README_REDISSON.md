# 项目说明
redisson客户端

#### git地址：
https://github.com/redisson/redisson/wiki/%E7%9B%AE%E5%BD%95

#### 其他项目：
其他各个项目都基于每个master上来进行开发



#### 分布式锁一般有三种实现方式：

        1.基于数据库的乐观锁

        2.基于redis的分布式锁

        3.基于zookeepr的分布式锁

    本文介绍第二种，基于redis的分布式锁，官方推荐用redisson，redisson支持四种连接方式，文中写了两种一个是单体，一个是集群

Cluster集群,Sentinel哨兵,Master/Slave主从,Single单体


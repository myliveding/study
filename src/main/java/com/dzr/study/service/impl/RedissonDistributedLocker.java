package com.dzr.study.service.impl;

import com.dzr.study.service.DistributedLocker;
import org.redisson.api.*;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: dingzr
 * @Date: 2019/6/3 11:20
 * @Description:
 */

@Component
public class RedissonDistributedLocker implements DistributedLocker {

    @Autowired
    private RedissonClient redissonClient;

    public void getRedissonClient() throws IOException {
                 Config config = redissonClient.getConfig();
                 System.out.println(config.toJSON().toString());
             }

              /**`
        * 获取字符串对象
        *
        * @param objectName
        * @return
        */
              public <T> RBucket<T> getRBucket(String objectName) {
                 RBucket<T> bucket = redissonClient.getBucket(objectName);
                 return bucket;
             }

              /**
        * 获取Map对象
        *
        * @param objectName
        * @return
        */
              public <K, V> RMap<K, V> getRMap(String objectName) {
                 RMap<K, V> map = redissonClient.getMap(objectName);
                 return map;
             }

              /**
        * 获取有序集合
        *
        * @param objectName
        * @return
        */
              public <V> RSortedSet<V> getRSortedSet(String objectName) {
                 RSortedSet<V> sortedSet = redissonClient.getSortedSet(objectName);
                 return sortedSet;
             }

              /**
        * 获取集合
        *
        * @param objectName
        * @return
        */
              public <V> RSet<V> getRSet(String objectName) {
                 RSet<V> rSet = redissonClient.getSet(objectName);
                 return rSet;
             }

              /**
        * 获取列表
        *
        * @param objectName
        * @return
        */
              public <V> RList<V> getRList(String objectName) {
                 RList<V> rList = redissonClient.getList(objectName);
                 return rList;
             }

              /**
        * 获取队列
        *
        * @param objectName
        * @return
        */
              public <V> RQueue<V> getRQueue(String objectName) {
                 RQueue<V> rQueue = redissonClient.getQueue(objectName);
                 return rQueue;
             }

              /**
        * 获取双端队列
        *
        * @param objectName
        * @return
        */
              public <V> RDeque<V> getRDeque(String objectName) {
                 RDeque<V> rDeque = redissonClient.getDeque(objectName);
                 return rDeque;
             }



             /**
     * 获取原子数
      *
      * @param objectName
     * @return
     */
          public RAtomicLong getRAtomicLong(String objectName) {
               RAtomicLong rAtomicLong = redissonClient.getAtomicLong(objectName);
               return rAtomicLong;
          }

             /**
       * 获取记数锁
       *
       * @param objectName
       * @return
       */
    public RCountDownLatch getRCountDownLatch(String objectName) {
        RCountDownLatch rCountDownLatch = redissonClient.getCountDownLatch(objectName);
        return rCountDownLatch;
    }

    /**
     * 获取消息的Topic
     * @param objectName
     * @return
     */
    public  RTopic getRTopic(String objectName) {
        RTopic rTopic = redissonClient.getTopic(objectName);
        return rTopic;
    }


    /**
     * 没有超时时间,默认30s
     * @param lockKey
     * @return
     */
    @Override
    public RLock lock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock();
        return lock;
    }

    /**
     * 自己设置超时时间
     * @param lockKey 锁的key
     * @param timeout  秒  如果是-1，直到自己解锁，否则不会自动解锁
     * @return
     */
    @Override
    public RLock lock(String lockKey, int timeout) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(timeout, TimeUnit.SECONDS);
        return lock;
    }

    @Override
    public RLock lock(String lockKey, TimeUnit unit, int timeout) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.lock(timeout,unit);
        return lock;
    }

    /**
     *
     * @param lockKey  锁key
     * @param unit  锁单位
     * @param waitTime   等到最大时间，强制获取锁
     * @param leaseTime  锁失效时间
     * @return
     */
    @Override
    public boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime) {
        RLock lock = redissonClient.getLock(lockKey);
        try {
            return lock.tryLock(waitTime,leaseTime,unit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void unlock(String lockKey) {
        RLock lock = redissonClient.getLock(lockKey);
        lock.unlock();
    }

    @Override
    public void unlock(RLock lock) {
        lock.unlock();
    }

}

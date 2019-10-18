package framework.redis;

//redis分布式锁

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.spring.cache.RedissonSpringCacheManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class Test {

    @Autowired
    private RedissonSpringCacheManager redissonSpringCacheManager;

    public static void main(String[] args) {
        RedissonClient client = Redisson.create();
        RLock lock = client.getLock("test");
        lock.lock(1000, TimeUnit.MILLISECONDS);
        lock.unlock();
    }
}

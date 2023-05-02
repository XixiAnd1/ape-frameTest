package com.jingdianjichi.user.cache;

import com.jingdianjichi.redis.init.AbstractCache;
import com.jingdianjichi.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class SysUserCache  extends AbstractCache {
    private static final String SYS_USER_CACHE_KEY = "SYS_USER";
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private RedisTemplate redisTemplate;
    @Override
    public void initCache() {
        redisUtil.set("age","18");
    }

    @Override
    public <T> T getCache(String key) {
        if(!redisTemplate.hasKey(key).booleanValue()){
            reloadCache();
        }
        return (T)redisTemplate.opsForValue().get(key);
    }

    @Override
    public void clearCache( ) {
        redisTemplate.delete(SYS_USER_CACHE_KEY);
    }

    @Override
    public void reloadCache() {
        super.reloadCache();
    }
}

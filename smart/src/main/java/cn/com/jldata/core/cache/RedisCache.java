package cn.com.jldata.core.cache;

import cn.com.jldata.core.util.Md5Utils;
import cn.com.jldata.core.util.SerializeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.lang.Nullable;

import java.util.Set;
import java.util.concurrent.Callable;

public class RedisCache implements Cache {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private RedisTemplate<String, Object> redisTemplate;
    private String name;

    public RedisCache(String name, RedisTemplate<String, Object> redisTemplate) {
        if (redisTemplate == null) {
            throw new IllegalArgumentException("Cache argument cannot be null.");
        } else {
            this.redisTemplate = redisTemplate;
            this.name = name;
        }
    }


    private String getByteKey(Object key) {
        return !(key instanceof String) && !(key instanceof Number) ? Md5Utils.md5(SerializeUtils.serialize(key)) :  key.toString();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        return this.redisTemplate;
    }

    @Nullable
    @Override
    public ValueWrapper get(Object key) {
        Object value = this.redisTemplate.opsForValue().get(this.getByteKey(key));
        return value != null ? new SimpleValueWrapper(value) : null;
    }

    @Nullable
    @Override
    public <T> T get(Object key, @Nullable Class<T> aClass) {
        Object value = this.redisTemplate.opsForValue().get(this.getByteKey(key));
        if (value != null && aClass != null && !aClass.isInstance(value)) {
            throw new IllegalStateException("Cached value is not of required type [" + aClass.getName() + "]: " + value);
        } else {
            return (T) value;
        }

    }

    @Nullable
    @Override
    public <T> T get(Object key, Callable<T> callable) {
        Object value = this.redisTemplate.opsForValue().get(this.getByteKey(key));
        try {
            callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T)value;

    }

    @Override
    public void put(Object key, @Nullable Object value) {
        this.logger.debug("根据key从存储 key [" + key + "]");
        ValueOperations valueOps = this.redisTemplate.opsForValue();
         valueOps.set(this.getByteKey(key), value);
    }
    protected Cache.ValueWrapper toValueWrapper(@Nullable Object storeValue) {
        return (storeValue != null ? new SimpleValueWrapper(storeValue) : null);
    }
    @Nullable
    @Override
    public ValueWrapper putIfAbsent(Object key, @Nullable Object value) {
        ValueOperations valueOps = this.redisTemplate.opsForValue();
        valueOps.set(this.getByteKey(key), value);
        return toValueWrapper(value);
    }

    @Override
    public void evict(Object key) {
        this.redisTemplate.delete(this.getByteKey(key));
    }

    @Override
    public void clear() {
        Set<String> keys = this.redisTemplate.keys( "*");
        this.redisTemplate.delete(keys);
    }


}
package org.bysj.pleural.helper;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * <pre>类名: RedisHelp</pre>
 * <pre>描述: redis帮助类封装常用的操作</pre>
 * <pre>日期: 2018/3/14  15:36</pre>
 * <pre>作者: ljianf</pre>
 */
@Component
@Slf4j
public class RedisHelp {


    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 缓存value操作
     * @param key
     * @param value
     * @param time
     * @return
     */
    public boolean cacheValue(String key, Object value, Long time) {
        try {
            redisTemplate.opsForValue().set(key, value);
            if (time!=null &&time > 0l) redisTemplate.expire(key, time, TimeUnit.SECONDS);
            return true;
        } catch (Exception t) {
            log.error("缓存[" + key + "]失败, value[" + value + "]", t);
        }
        return false;
    }

    /**
     * 缓存value操作
     * @param key
     * @param value
     * @return
     */
    public boolean cacheValue(String key, String value) {
        return cacheValue(key, value, null);
    }
    /**
     * 缓存value操作
     * @param key
     * @param value
     * @return
     */
    public boolean cacheValue(String key, Object value) {
        return cacheValue(key, value, null);
    }

    /**
     * @Description: 是否存在缓存
     * @date   2018/3/14 15:44
     * @param
     * @return
     * @author ljianf
     */
    public boolean containsKey(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception t) {
            log.error("判断缓存存在失败key[" + key + ", error[" + t + "]");
        }
        return false;
    }

  /**
   * @Description: 获取缓存数据
   * @date   2018/3/14 15:46
   * @param
   * @return
   * @author ljianf
   */
    public Object getValue(String key) {
        try {
             return redisTemplate.opsForValue().get(key);
        } catch (Exception t) {
            log.error("获取缓存失败key[" + key + ", error[" + t + "]");
        }
        return null;
    }

    /**
     * 移除缓存
     * @param key
     * @return
     */
    public boolean remove(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception t) {
            log.error("获取缓存失败key[" + key + ", error[" + t + "]");
        }
        return false;
    }
}

package com.kaishengit.redis;

import com.alibaba.fastjson.JSON;
import com.kaishengit.entity.User;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jinjianghao
 * @date 2018/8/22
 */
public class RedisTest {

    @Test
    public void poolTest() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxTotal(10);
        config.setMinIdle(5);

        JedisPool jedisPool = new JedisPool(config,"192.168.1.205",6379);
        Jedis jedis = jedisPool.getResource();

        jedis.set("name","jerry");

        jedis.close();
    }

    @Test
    public void setUser() {
        Jedis jedis = new Jedis("192.168.1.205", 6379);

        User user = new User();
        user.setId(1001);
        user.setUserName("jack");
        user.setAddress("jiaozuo");

        String json = JSON.toJSONString(user);
        jedis.set("user:1001", json);
        jedis.close();

    }

    @Test
    public void getUser() {
        Jedis jedis = new Jedis("192.168.1.205", 6379);

        String json = jedis.get("user:1001");

        User user = JSON.parseObject(json, User.class);
        System.out.println(user);
        jedis.close();

    }


    @Test
    public void setString() {
        Jedis jedis = new Jedis("192.168.1.205", 6379);
        jedis.set("name", "jack");

        jedis.close();
    }

    @Test
    public void getString() {
        Jedis jedis = new Jedis("192.168.1.205", 6379);
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();
    }

    @Test
    public void setHash() {
        Jedis jedis = new Jedis("192.168.1.205",6379);
        jedis.hset("names:1001","id","1");
        Map<String, String> maps = new HashMap<String, String>();
        maps.put("userName", "jack");
        maps.put("address", "beijing");
        jedis.hmset("names:1001", maps);

        jedis.close();
    }

    @Test
    public void getHash() {
        Jedis jedis = new Jedis("192.168.1.205",6379);
//        String id = jedis.hget("names:1001", "id");
//        System.out.println(id);
        Set<String> hkeys = jedis.hkeys("names:1001");

        for(String key : hkeys) {
            System.out.println(key);
        }

        Object[] array =hkeys.toArray();
        String[] strArray = new String[hkeys.toArray().length];
        for(int i = 0;i < array.length;i++) {
            Object obj = array[i];
            String str = obj.toString();
            strArray[i] = str;
        }

        List<String> hmget = jedis.hmget("names:1001", strArray);
        for(String field : hmget) {
            System.out.println(field);
        }

        jedis.close();
    }

}

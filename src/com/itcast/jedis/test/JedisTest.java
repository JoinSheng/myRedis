package com.itcast.jedis.test;

import com.itcast.jedis.Utils.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Set;

/**
 * @Author: JoinCao
 * @CreateDate: 2020-06-05
 */
public class JedisTest {
    @Test
    public void Test01() {
        //获取连接
        Jedis jedis = new Jedis("localhost", 6379);
        //1.String类型
        //操作
        jedis.set("java", "hello");
        //获取
        String java = jedis.get("java");
        System.out.println(java);
        //删除
        jedis.del("java");
        System.out.println(jedis.get("java"));
        System.out.println("........");

        //2.list列表类型
        jedis.lpush("mylist", "a", "b", "hello");//从左边存储
        jedis.rpush("mylist", "aa", "bb", "hello");//从右边存储

        //获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        //删除
        jedis.lpop("mylist");  //从左边
        jedis.rpop("mylist");  //从右边
        System.out.println("........");

        //3.hash类型
        jedis.hset("myhash", "西游记", "唐僧");
        jedis.hset("myhash", "红楼梦", "宝玉");
        jedis.hgetAll("myhash");
        jedis.hget("myhash", "西游记");

        //4.set类型
        jedis.sadd("myset", "a", "b", "c");
        jedis.smembers("myset");
        jedis.srem("myset", "a");

        //5.sortedset类型
        jedis.zadd("mysortedset", 60, "a");
        jedis.zadd("mysortedset", 60, "aa");
        jedis.zrange("mysortedset", 0, -1);
        jedis.zrem("mysortedset", "aa");
        //关闭连接
        jedis.close();
    }

    //连接池
    @Test
    public void Test02() {
        //创建配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        //创建Jedis连接池对象
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);
        //JedisPool jedisPool1 = new JedisPool();
        //创建连接
        Jedis jedis = jedisPool.getResource();
        //使用
        jedis.set("myString", "红楼梦");

    }

    public void Test03() {
        Jedis jedis = JedisPoolUtils.getJedis();
        //使用
        jedis.set("myString", "红楼梦");
        JedisPoolUtils.getClose();
    }
}

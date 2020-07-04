package com.itcast.jedis.Utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Description: 连接池工具类练习
 * @Author: JoinCao
 * @CreateDate: 2020-06-06
 * @UpdateUser: JoinCao
 * @UpdateDate: 2020-06-06
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class JedisPoolUtils {
    //成员变量私有
    private static JedisPool jedisPool;

    //静态代码块初始化JedisPool
    static {
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties pro = new Properties();
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxIble")));
        //初始化jedisPool
        jedisPool = new JedisPool(config, pro.getProperty("host"), Integer.parseInt(pro.getProperty("port")));
    }

    //成员方法静态
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    public static void getClose() {
        getJedis().close();
    }
}

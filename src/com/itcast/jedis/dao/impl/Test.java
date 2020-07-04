package com.itcast.jedis.dao.impl;

/**
 * @Author: JoinCao
 * @CreateDate: 2020-06-10
 */
public class Test {
    public static void main(String[] args) {
        int x = 0;
        int y = 0;
        int k = 0;
        for (int z = 0; z < 5; z++) {
            if ((++x > 2) && (++y > 2) && (++k > 0)) {
                x++;
            }
            // System.out.println(x + 1);
        }
        System.out.println(x);
    }
}

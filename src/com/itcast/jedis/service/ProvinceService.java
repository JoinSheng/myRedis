package com.itcast.jedis.service;

import com.itcast.jedis.domain.Province;

import java.util.List;

/**
 * @Author: JoinCao
 * @CreateDate: 2020-06-06
 */
public interface ProvinceService {
    List<Province> findAll();
}

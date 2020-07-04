package com.itcast.jedis.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itcast.jedis.dao.ProvinceDao;
import com.itcast.jedis.dao.impl.ProvinceDaoImpl;
import com.itcast.jedis.domain.Province;
import com.itcast.jedis.service.ProvinceService;

import java.util.List;

/**
 * @Author: JoinSheng
 * @CreateDate: 2020-06-06
 */
public class ProvinceServiceImpl implements ProvinceService {
    @Override
    public List<Province> findAll() {

        ProvinceDao provinceDao = new ProvinceDaoImpl();
        List<Province> list = provinceDao.findAll();
        return list;
    }
}

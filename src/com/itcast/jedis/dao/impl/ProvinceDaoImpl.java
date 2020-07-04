package com.itcast.jedis.dao.impl;

import com.itcast.jedis.Utils.JDBCUtils;
import com.itcast.jedis.dao.ProvinceDao;
import com.itcast.jedis.domain.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author: JoinCao
 * @CreateDate: 2020-06-06
 */
public class ProvinceDaoImpl implements ProvinceDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        String sql = "select * from province";
        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));
        return list;
    }
}

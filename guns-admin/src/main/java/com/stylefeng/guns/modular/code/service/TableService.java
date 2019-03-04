package com.stylefeng.guns.modular.code.service;

import com.baomidou.mybatisplus.mapper.SqlRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 获取数据库所有的表
 *
 * @author fengshuonan
 * @date 2017-12-04-下午1:37
 */
@Service
public class TableService {

    @Value("${spring.datasource.db-name}")
    private String dbName;

    @Value("${guns.muti-datasource.db-name}")
    private String bizDbName;

    @Value("${guns.financing-datasource.db-name}")
    private String financingDbName;
    @Value("${guns.settlement-datasource.db-name}")
    private String settlementDbName;
    /**
     * 获取当前数据库所有的表信息
     */
    public List<Map<String, Object>> getAllTables() {
        List<Map<String, Object>> list = new ArrayList<>();
        String sql = "select TABLE_NAME as tableName,TABLE_COMMENT as tableComment from information_schema.`TABLES` where TABLE_SCHEMA = '" + dbName + "'";
        list.addAll(SqlRunner.db().selectList(sql));
        sql = "select TABLE_NAME as tableName,TABLE_COMMENT as tableComment from information_schema.`TABLES` where TABLE_SCHEMA = '" + bizDbName + "'";
        list.addAll(SqlRunner.db().selectList(sql));
        sql = "select TABLE_NAME as tableName,TABLE_COMMENT as tableComment from information_schema.`TABLES` where TABLE_SCHEMA = '" + financingDbName + "'";
        list.addAll(SqlRunner.db().selectList(sql));
        sql = "select TABLE_NAME as tableName,TABLE_COMMENT as tableComment from information_schema.`TABLES` where TABLE_SCHEMA = '" + settlementDbName + "'";
        list.addAll(SqlRunner.db().selectList(sql));
        return list;
    }
}

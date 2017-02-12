package com.stu.dao;

/**
 * Created by huser
 * On 17/2/8.
 */
public class BaseDao {
    protected String getPath() {
        return BaseDao.class.getResource("/data/data.properties").getPath().replaceAll("%20", " ");
    }
}

package com.stu.dao;

/**
 * Created by huser
 * On 17/2/8.
 */
public class BaseDao {
    public String getPath() {
        return ClassLoader.class.getResource("/data/data.properties").toString().substring(6);
    }

    public static void main(String[] args) {
        BaseDao dao = new BaseDao();
        System.err.println(dao.getPath());
    }
}

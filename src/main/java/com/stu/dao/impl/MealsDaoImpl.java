package com.stu.dao.impl;

import com.stu.dao.BaseDao;
import com.stu.dao.MealsDao;
import com.stu.model.Meals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by huser
 * On 17/2/8.
 */
@Repository
public class MealsDaoImpl extends BaseDao implements MealsDao {
    private final Logger logger = LoggerFactory.getLogger(MealsDaoImpl.class);

    @Override
    public String updateMeals(Meals meals) throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(getPath());
        properties.load(fis);
        if (properties.containsKey(meals.getOwner())) {
            System.err.println(meals.getBalance());
            if (meals.getBalance().indexOf("-") == 0) {
                properties.setProperty(meals.getOwner(), String.valueOf(Float.valueOf(properties.getProperty(meals.getOwner()))
                        + Float.valueOf((meals.getBalance()).substring(1, meals.getBalance().length()))));
            } else {
                properties.setProperty(meals.getOwner(), String.valueOf(Float.valueOf(properties.getProperty(meals.getOwner())) - Float.valueOf(meals.getBalance())));
            }
        } else {
            logger.warn("没有这个用户！");
        }
        FileOutputStream fos = new FileOutputStream(getPath());
        properties.store(fos, "Update properties");
        fos.close();
        fis.close();
        return properties.getProperty(meals.getOwner());
    }

    @Override
    public String selectMeals(String owner) throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(getPath());
        properties.load(fis);
        return properties.getProperty(owner);
    }
}

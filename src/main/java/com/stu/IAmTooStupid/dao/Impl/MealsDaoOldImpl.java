package com.stu.IAmTooStupid.dao.Impl;

import com.stu.dao.BaseDao;
import com.stu.IAmTooStupid.dao.MealsDaoOld;
import com.stu.model.Meals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;

/**
 * Created by huser
 * On 17/2/8.
 */
public class MealsDaoOldImpl extends BaseDao implements MealsDaoOld {
    private final Logger logger = LoggerFactory.getLogger(MealsDaoOldImpl.class);

    @Override
    public String updateMeals(Meals meals) throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(getPath());
        properties.load(fis);
        if (properties.containsKey(meals.getOwner())) {
            System.err.println(meals.getBalance());
            if (meals.getBalance().indexOf("-") == 0) {
                properties.setProperty(meals.getOwner(),
                        String.valueOf(BigDecimal.valueOf(Long.parseLong(properties.getProperty(meals.getOwner())))
                                .add(BigDecimal.valueOf(Long.parseLong((meals.getBalance()).substring(1, meals.getBalance().length()))))));
            } else {
                properties.setProperty(meals.getOwner(),
                        String.valueOf(BigDecimal.valueOf(Long.parseLong(properties.getProperty(meals.getOwner())))
                                .subtract(BigDecimal.valueOf(Long.parseLong(meals.getBalance())))));
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

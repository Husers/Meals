package com.stu.dao.impl;

import com.stu.dao.MealsDao;
import com.stu.dao.BaseDao;
import com.stu.model.Meals;
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

    @Override
    public void updateMeals(Meals meals) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(getPath()));
        if (properties.containsKey(meals.getOwner())) {
            properties.setProperty(meals.getOwner(), String.valueOf(Float.valueOf(properties.getProperty(meals.getOwner())) - Float.valueOf(meals.getBalance())));
            System.out.println(properties.getProperty(meals.getOwner()));
        } else {
            System.err.println("没有这个用户！");
        }
        FileOutputStream fos = new FileOutputStream(getPath());
        properties.store(fos, "Update properties");
    }

    public static void main(String[] args) {
        MealsDaoImpl dao = new MealsDaoImpl();
    }
}

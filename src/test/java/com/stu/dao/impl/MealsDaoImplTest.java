package com.stu.dao.impl;

import com.stu.Base;

import com.stu.dao.MealsDao;
import com.stu.model.Meals;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by huser
 * On 17/2/12.
 */
public class MealsDaoImplTest extends Base {
    @Autowired
    private MealsDao dao;
    @Autowired
    private Meals model;
    @Test
    public void selectMealsByOwner() throws Exception {

    }

    @Test
    public void updateMealsByOwner() throws Exception {
        model.setOwner("huliang");
        model.setBalance("20");
        System.err.println(dao.selectMealsByOwner(model.getOwner()));
        dao.updateMealsByOwner(model);
        System.err.println(dao.selectMealsByOwner(model.getOwner()));
    }

}
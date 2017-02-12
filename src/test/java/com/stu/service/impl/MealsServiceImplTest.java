package com.stu.service.impl;

import com.stu.Base;
import com.stu.model.Meals;
import com.stu.service.MealsService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by huser
 * On 17/2/12.
 */
public class MealsServiceImplTest extends Base {
    @Autowired
    private MealsService service;
    @Autowired
    private Meals model;

    @Test
    public void updateMeals() throws Exception {
        model.setOwner("huliang");
        model.setBalance("200");
        service.updateMeals(model);
        System.err.println(service.selectMeals(model.getOwner()));
    }

    @Test
    public void selectMeals() throws Exception {

    }

}
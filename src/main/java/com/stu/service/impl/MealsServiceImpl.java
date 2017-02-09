package com.stu.service.impl;

import com.stu.model.Meals;
import com.stu.service.MealsService;
import com.stu.dao.MealsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by huser
 * On 17/2/8.
 */
@Service
public class MealsServiceImpl implements MealsService {
    private final MealsDao dao;

    @Autowired
    public MealsServiceImpl(MealsDao dao) {
        this.dao = dao;
    }

    @Override
    public void updateMeals(Meals meals) throws IOException {
        dao.updateMeals(meals);
    }
}

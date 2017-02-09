package com.stu.service;

import com.stu.model.Meals;

import java.io.IOException;

/**
 * Created by huser
 * On 17/2/8.
 */
public interface MealsService {
    void updateMeals(Meals meals) throws IOException;
}

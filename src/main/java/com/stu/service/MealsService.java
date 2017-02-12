package com.stu.service;

import com.stu.model.Meals;

/**
 * Created by huser
 * On 17/2/8.
 */
public interface MealsService {
    String updateMeals(Meals meals);

    String selectMeals(String owner);
}

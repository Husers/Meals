package com.stu.dao;

import com.stu.model.Meals;

/**
 * Created by huser
 * On 17/2/12.
 */
public interface MealsDao {
    String selectMealsByOwner(String owner);

    void updateMealsByOwner(Meals meals);

    boolean selectOwner(String owner);
}

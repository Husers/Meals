package com.stu.dao;

import com.stu.model.Meals;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by huser
 * On 17/2/8.
 */
public interface MealsDao {
    public void updateMeals(Meals meals) throws IOException;
}

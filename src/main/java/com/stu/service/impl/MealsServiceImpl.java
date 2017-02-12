package com.stu.service.impl;


import com.stu.dao.MealsDao;
import com.stu.model.Meals;
import com.stu.service.MealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;

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
    public String updateMeals(Meals meals){
        BigDecimal balance = new BigDecimal(dao.selectMealsByOwner(meals.getOwner()));
        BigDecimal balanceC = new BigDecimal(meals.getBalance());
        String balanceNew = String.valueOf(balance.subtract(balanceC));
        meals.setBalance(balanceNew);
        dao.updateMealsByOwner(meals);
        return balanceNew;
    }

    @Override
    public String selectMeals(String owner) {
        return dao.selectMealsByOwner(owner);
    }
}

package com.stu.web;

import com.stu.model.Meals;
import com.stu.service.MealsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by huser
 * On 17/2/8.
 */
@Controller
public class MealsController {
    private final MealsService service;
    private final Meals meals;
    private final Logger logger = LoggerFactory.getLogger(MealsController.class);

    @Autowired
    public MealsController(MealsService service, Meals meals) {
        this.service = service;
        this.meals = meals;
    }

    @RequestMapping(value = "/925659/{owner}/update")
    @ResponseBody
    public String updateMeals(@PathVariable("owner") String owner, @RequestParam(value = "balance") String balance) {
        meals.setOwner(owner);
        meals.setBalance(balance);
        logger.info(owner + "消费了" + balance);
        try {
            service.updateMeals(meals);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "{\"status\":\"200\"}";
    }
}

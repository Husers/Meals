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

    @RequestMapping(value = "/925659/{owner}/minus")
    @ResponseBody
    public String minusMeals(@PathVariable("owner") String owner, @RequestParam(value = "balance") String balance) {
        meals.setOwner(owner);
        meals.setBalance(balance);
        String balanceT = service.updateMeals(meals);
        if ( balanceT!= null) {
            logger.info(owner + " 消费了" + balance);
        } else {
            logger.warn(owner + " 扣款失败，没有这个用户");
        }
        return "{\"balance\":\"" + balanceT + "\"}";
    }

    @RequestMapping(value = "/925659/{owner}/plus")
    @ResponseBody
    public String plusMeals(@PathVariable("owner") String owner, @RequestParam(value = "balance") String balance) {
        meals.setOwner(owner);
        meals.setBalance("-" + balance);
        String balanceT = service.updateMeals(meals);
        if (balanceT != null) {
            logger.info(owner + " 充值了" + balance);
        } else {
            logger.warn(owner + " 充值失败，没有这个用户");
        }
        return "{\"balance\":\"" + balanceT + "\"}";
    }
}

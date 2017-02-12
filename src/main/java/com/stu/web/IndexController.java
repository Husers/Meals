package com.stu.web;

import com.stu.service.MealsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

/**
 * Created by huser
 * On 17/2/8.
 */
@Controller
public class IndexController {
    private final MealsService service;

    @Autowired
    public IndexController(MealsService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/925659")
    public String login() {
        return "login";
    }

    @RequestMapping("/925659/{owner}")
    public ModelAndView meals(@PathVariable("owner") String owner) {
        String balance = service.selectMeals(owner);
        return new ModelAndView("meals", "balance", balance);
    }
}

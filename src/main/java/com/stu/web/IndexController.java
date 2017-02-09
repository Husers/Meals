package com.stu.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by huser
 * On 17/2/8.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/925659")
    public String login() {
        return "login";
    }

    @RequestMapping("/925659/*")
    public String meals() {
        return "meals";
    }
}

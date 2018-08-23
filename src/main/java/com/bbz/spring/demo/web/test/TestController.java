package com.bbz.spring.demo.web.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    String local = "";

    @ModelAttribute("cityList")
    public List cityList() {
        return Arrays.asList("北京", "山东");
    }

    @ModelAttribute
    public void populateModel(@RequestParam String abc, Model model) {
        model.addAttribute("name", abc);
    }

    @ModelAttribute
    public void populateModel1() {
        local = "liulaoye";
    }


    @RequestMapping(value = "/helloWorld")

    public String helloWorld(Model model, @RequestHeader("User-Agent") String userAgent) {
        System.out.println(model.asMap().get("name"));
        return model.asMap().get("name").toString() + "|" + local + " | " + model.asMap().get("cityList") + userAgent;

    }
}

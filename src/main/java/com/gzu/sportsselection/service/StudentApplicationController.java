//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gzu.sportsselection.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentApplicationController {
    public StudentApplicationController() {
    }

    @GetMapping({"/index"})
    public String home() {
        return "index";
    }
}

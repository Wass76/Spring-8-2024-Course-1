package com.SpringCourse.Startup.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/manager")
public class ManagementController {
    @GetMapping
    public String hello() {
        return "management controller";
    }
}

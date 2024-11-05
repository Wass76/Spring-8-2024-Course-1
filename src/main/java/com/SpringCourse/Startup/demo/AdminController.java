package com.SpringCourse.Startup.demo;

import lombok.Getter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
@PreAuthorize("hasRole(ADMIN)")
public class AdminController {


    @GetMapping
    @PreAuthorize("hasAuthority('admin:read')")
    public String admin() {
        return "admin";
    }




}

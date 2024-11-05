package com.SpringCourse.Startup.Security.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {


    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    MANAGER_READ("manager:read"),
    MANAGER_UPDATE("manager:update");


    @Getter
    private final String permisson;
}

package com.SpringCourse.Startup.Security.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public enum Role {
    USER(Collections.EMPTY_SET),
    ADMIN(
            Set.of(
                    Permission.ADMIN_READ,
                    Permission.ADMIN_UPDATE
            )
    ),
    Manager(
            Set.of(
                    Permission.MANAGER_UPDATE,
                    Permission.MANAGER_READ
            )
    )
    ;


    @Getter
    private final Set<Permission> permissionset;



    public List<SimpleGrantedAuthority> getAuthority() {
        var auth = getPermissionset()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermisson()))
                .collect(Collectors.toList());
        auth.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return auth;
    }

}

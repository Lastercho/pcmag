package org.isbg.pcmag.security;

import org.elasticsearch.common.util.set.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static org.isbg.pcmag.security.ApplicationUserPermission.*;

public enum ApplicationUserRole {
    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(USER_READ, USER_WRITE, PARTS_READ,PARTS_WRITE,PERIPHERALS_READ,PERIPHERALS_WRITE,PCS_READ,PCS_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(USER_READ, PARTS_READ,PERIPHERALS_READ,PCS_READ));

    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions){
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add( new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}

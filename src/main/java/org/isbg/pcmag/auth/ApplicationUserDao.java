package org.isbg.pcmag.auth;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUser> selectApplicationUserByUsername(String username);
}

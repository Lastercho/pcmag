package org.isbg.pcmag.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.isbg.pcmag.security.ApplicationUserRole.*;


@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {

        return getApplicationUsers().stream().filter(applicationUser -> username.equals(applicationUser.getUsername())).findFirst();
    }


    private List<ApplicationUser> getApplicationUsers(){
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                new ApplicationUser("laster",
                        passwordEncoder.encode("11111"),
                        ADMIN.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true

                        ),
                new ApplicationUser("toni",
                        passwordEncoder.encode("11111"),
                        ADMINTRAINEE.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true

                ),
                new ApplicationUser("stoyan",
                        passwordEncoder.encode("11111"),
                        USER.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true

                )
        );
        return applicationUsers;
    }

}

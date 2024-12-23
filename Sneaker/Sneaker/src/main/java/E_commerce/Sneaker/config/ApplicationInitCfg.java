package E_commerce.Sneaker.config;


import E_commerce.Sneaker.constant.PredefinedRole;
import E_commerce.Sneaker.model.Role.Role;
import E_commerce.Sneaker.model.User.User;
import E_commerce.Sneaker.repository.RoleRepository;
import E_commerce.Sneaker.repository.UserRepository;
import lombok.experimental.NonFinal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

/**
 * This class create an admin account if not exist, when run the application
 */
@Configuration
public class ApplicationInitCfg {

    private static final Logger log = LoggerFactory.getLogger(ApplicationInitCfg.class);
    @Autowired
    private PasswordEncoder passwordEncoder;

    @NonFinal
    static final String ADMIN_USERNAME = "admin";

    @NonFinal
    static final String ADMIN_PASSWORD = "123admin456";

    @Bean
    /*@ConditionalOnProperty(
            prefix = "spring",
            value = "datasource.driverClassName",
            havingValue = ""
    )*/
    ApplicationRunner applicationRunner(UserRepository userRepository, RoleRepository roleRepository) {
        return args -> {
            if (userRepository.findByUsername(ADMIN_USERNAME).isEmpty()) {
                roleRepository.save(Role.builder()
                        .role_name(PredefinedRole.USER_ROLE)
                        .description("User role")
                        .build());

                Role adminRole = roleRepository.save(Role.builder()
                        .role_name(PredefinedRole.ADMIN_ROLE)
                        .description("Admin role")
                        .build());

                var roles = new HashSet<Role>();
                roles.add(adminRole);

                User user = User.builder()
                        .username(ADMIN_USERNAME)
                        .password(passwordEncoder.encode(ADMIN_PASSWORD))
                        .roles(roles)
                        .build();

                userRepository.save(user);
                log.warn("admin user has been created with default password: 123admin456");
            }
        };
    }
}

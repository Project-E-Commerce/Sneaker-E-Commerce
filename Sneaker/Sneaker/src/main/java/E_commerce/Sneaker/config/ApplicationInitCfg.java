package E_commerce.Sneaker.config;

import E_commerce.Sneaker.enums.Role;
import E_commerce.Sneaker.model.User.User;
import E_commerce.Sneaker.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
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

    @Bean
    ApplicationRunner applicationRunner(UserRepository userRepository){
        return args -> {
            var roles = new HashSet<String>();
            roles.add(Role.ADMIN.name());
            if(userRepository.findByUsername("admin").isEmpty()){
                User user = User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("123admin456"))
//                        .roles(roles)
                        .build();

                userRepository.save(user);
                log.warn("admin user has been created with default password: 123admin456");
            }
        };
    }
}

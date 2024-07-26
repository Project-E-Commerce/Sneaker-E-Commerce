package E_commerce.Sneaker.Service;

import E_commerce.Sneaker.model.User.MyUserDetails;
import E_commerce.Sneaker.model.User.User;
import E_commerce.Sneaker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JpaUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException{
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent()){
            return new MyUserDetails(user.get());
        }else{
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }
}

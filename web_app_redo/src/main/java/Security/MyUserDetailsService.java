package Security;

import com.example.demo.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        Optional<Login> login = userRepo.findByUsername(userName);

        login.orElseThrow(() -> new UsernameNotFoundException(userName + " not found!"));

        return login.map(UserDetailsImp::new).get();
    }
}
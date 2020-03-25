//package Security;
//
//import com.example.demo.Login;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailsServiceConfig implements UserDetailsService {
//
//    @Autowired
//    private UserRepo db;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
//        Login user = db.findByUsername(username);
//        if (user == null){
//            throw new UsernameNotFoundException("User doesn't exist!");
//        }
//        return new UserDetailsImp(user);
//    }
//}

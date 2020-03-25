//package Security;
//
//import com.example.demo.Login;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.Collections;
//
//public class UserDetailsImp implements UserDetails {
//
//    private Login user;
//
//    public UserDetailsImp(Login user){
//        super();
//        this.user = user;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return Collections.singleton(new SimpleGrantedAuthority("USER"));
//    }
//
//    @Override
//    public String getPassword() {
//        return user.getPass();
//    }
//
//    @Override
//    public String getUsername() {
//        return user.getUser();
//    }
//
//    public String getTier(){
//        return user.getTier();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true ;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}

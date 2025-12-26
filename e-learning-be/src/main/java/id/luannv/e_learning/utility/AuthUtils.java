package id.luannv.e_learning.utility;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuthUtils {
    public static boolean isLoggedIn(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return authentication != null && authentication.isAuthenticated();
    }
    public static boolean isAdmin(){
        return true;
    }
}

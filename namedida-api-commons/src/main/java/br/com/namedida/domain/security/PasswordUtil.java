package br.com.namedida.domain.security;

import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;


@Component
public class PasswordUtil {
    public static String encrypt(String password) {
        System.out.println(BCrypt.gensalt());
        System.out.println(BCrypt.hashpw(password, BCrypt.gensalt()));
        System.out.println(verify(password, BCrypt.hashpw(password, BCrypt.gensalt())));

        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean verify(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }
}
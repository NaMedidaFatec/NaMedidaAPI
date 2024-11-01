package br.com.namedida.core.controller;
import br.com.namedida.core.service.security.AuthenticationService;
import br.com.namedida.domain.Usuario;
import br.com.namedida.domain.form.AuthenticationForm;
import br.com.namedida.domain.security.UserAuthenticated;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) { this.service = service; }

    @PostMapping("/login")
    public String authenticate(
      @RequestBody AuthenticationForm authenticationForm) {
         return service.authenticate(authenticationForm);
    }

    @GetMapping("/me")
    public UserAuthenticated me(){
        var detail = (UserAuthenticated) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return detail;
    }

    @PostMapping("/signin")
    public Usuario signin(
            @RequestBody AuthenticationForm signinForm) throws Exception {
        return service.signin(signinForm);
    }
}
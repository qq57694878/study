package cn.com.jldata.core.controller;

import cn.com.jldata.core.body.LoginRequest;
import cn.com.jldata.core.vo.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

/*
        @Autowired
        private AuthService authService;

        @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
        public RestResult createAuthenticationToken(
                @RequestBody LoginRequest loginRequest){
             String token = authService.login(loginRequest.getUsername(), loginRequest.getPassword());
            return new RestResult(token);
        }

        @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
        public RestResult refreshAndGetAuthenticationToken() throws AuthenticationException{
            String token = request.getHeader(tokenHeader);
            String refreshedToken = authService.refresh(token);
            if(refreshedToken == null) {
                return ResponseEntity.badRequest().body(null);
            } else {
                return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
            }
        }

        @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
        public User register(@RequestBody User addedUser) throws AuthenticationException{
            return authService.register(addedUser);
        }*/

}

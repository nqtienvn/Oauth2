package com.tien.oauth2_demo.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

@Controller
public class MainController {
    private Logger logger = Logger.getLogger(MainController.class.getName());
    @GetMapping("/")
    public String main(OAuth2AuthenticationToken token) {
        //sau khi đăng nhập thành công thì nó sẽ lưu về một cái OAuthenticaiontoken luuw vào security context
        //
        logger.info(String.valueOf(token.getPrincipal()));
        return "main.html";
    }
}

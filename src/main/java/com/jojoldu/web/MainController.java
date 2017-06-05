package com.jojoldu.web;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 4.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@Controller
public class MainController {

    @GetMapping("/me")
    @ResponseBody
    public Object me(OAuth2Authentication oAuth2Authentication) {
        if(oAuth2Authentication == null) {
            return "redirect:/";
        }
        return oAuth2Authentication.getUserAuthentication().getDetails();
    }
}

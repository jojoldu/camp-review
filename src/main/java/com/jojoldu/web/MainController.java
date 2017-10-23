package com.jojoldu.web;

import com.jojoldu.domain.member.MemberRepository;
import com.jojoldu.oauth.GithubParser;
import com.jojoldu.oauth.pojo.Github;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
@AllArgsConstructor
public class MainController {

    private MemberRepository memberRepository;
    private GithubParser githubParser;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/me")
    @ResponseBody
    public Object me(OAuth2Authentication oAuth2Authentication) {
        if(oAuth2Authentication == null) {
            return "redirect:/";
        }
        Github github = githubParser.parse(oAuth2Authentication);
        return memberRepository.findByEmail(github.getEmail());
    }
}

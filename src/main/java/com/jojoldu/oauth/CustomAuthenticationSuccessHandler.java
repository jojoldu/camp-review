package com.jojoldu.oauth;

import com.jojoldu.domain.member.Member;
import com.jojoldu.domain.member.MemberRepository;
import com.jojoldu.oauth.pojo.Github;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 4.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@Component
@AllArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private MemberRepository memberRepository;
    private GithubParser githubParser;

    @Override
    @Transactional
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Github github = githubParser.parse(authentication);

        Optional<Member> optional = memberRepository.findByEmail(github.getEmail());
        if(optional.isPresent()){
            final Member member = optional.get();
            member.update(github.getName(), github.getEmail(), github.getAvatarUrl());
        } else {
            memberRepository.save(github.createMember());
        }

        response.sendRedirect("/");
    }
}

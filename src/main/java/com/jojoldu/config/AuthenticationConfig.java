package com.jojoldu.config;

import com.jojoldu.oauth.GithubDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 5.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@Configuration
@AllArgsConstructor
public class AuthenticationConfig extends GlobalAuthenticationConfigurerAdapter {

    private GithubDetailsService githubDetailsService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(githubDetailsService);
    }
}
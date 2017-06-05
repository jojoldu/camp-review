package com.jojoldu.config;

import com.jojoldu.oauth.GithubDetailsService;
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
public class AuthenticationConfig extends GlobalAuthenticationConfigurerAdapter {

    private final GithubDetailsService githubDetailsService;

    @Autowired
    public AuthenticationConfig(GithubDetailsService githubDetailsService) {
        this.githubDetailsService = githubDetailsService;
    }

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(githubDetailsService);
    }
}
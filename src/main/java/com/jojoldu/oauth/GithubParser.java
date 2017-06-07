package com.jojoldu.oauth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jojoldu.oauth.domain.Github;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Component;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 7.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@Component
public class GithubParser {

    private ObjectMapper objectMapper;

    public GithubParser(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public Github parse(Authentication authentication){
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
        Object details = oAuth2Authentication.getUserAuthentication().getDetails();
        Github github = objectMapper.convertValue(details, Github.class);

        return github;
    }
}

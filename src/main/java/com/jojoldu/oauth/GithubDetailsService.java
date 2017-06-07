package com.jojoldu.oauth;

import com.jojoldu.domain.member.Member;
import com.jojoldu.domain.member.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by jojoldu@gmail.com on 2017. 6. 5.
 * Blog : http://jojoldu.tistory.com
 * Github : https://github.com/jojoldu
 */

@Service
public class GithubDetailsService implements UserDetailsService {

    private MemberRepository memberRepository;

    public GithubDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Member> optional = memberRepository.findByEmail(email);

        if (!optional.isPresent()) {
            throw new UsernameNotFoundException("Not Found User");
        }

        return new GithubUserDetails(optional.get());
    }
}

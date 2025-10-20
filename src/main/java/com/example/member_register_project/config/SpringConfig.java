package com.example.member_register_project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.member_register_project.repository.MemberRepository;
import com.example.member_register_project.repository.MemoryMemberRepository;
import com.example.member_register_project.service.MemberService;

@Configuration
public class SpringConfig {
    
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}

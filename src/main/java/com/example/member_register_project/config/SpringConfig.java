package com.example.member_register_project.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.member_register_project.repository.MemberRepository;
import com.example.member_register_project.repository.MemoryMemberRepository;
import com.example.member_register_project.repository.JdbcMemberRepository;
import com.example.member_register_project.repository.JpaMemberRepository;
import com.example.member_register_project.service.MemberService;

import jakarta.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    // private EntityManager em;
    
    // private DataSource dataSource;

    // @Autowired
    // public SpringConfig(DataSource dataSource){
    //     this.dataSource = dataSource;
    // }

    // @Autowired
    // public SpringConfig(EntityManager em){
    //     this.em = em;
    // }

    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // @Bean
    // public MemberRepository memberRepository(){
    //     // return new JdbcMemberRepository(dataSource);
    //     return new JpaMemberRepository(em);
    // }
}

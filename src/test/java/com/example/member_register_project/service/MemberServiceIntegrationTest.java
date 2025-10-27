package com.example.member_register_project.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.lenient;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.member_register_project.domain.Member;
import com.example.member_register_project.repository.MemberRepository;
import com.example.member_register_project.repository.MemoryMemberRepository;

@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;


    @Test
    void testJoin() {
        // Given
        // Member 생성
        Member member = new Member();
        member.setName("민둔둔");

        // When
        Long saveId = memberService.join(member);

        // Then
        Member result = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(result.getName());

    }

    @Test
    public void 중복_회원_예외(){
        // Given
        Member member1 = new Member();
        member1.setName("민둔둔");
        
        Member member2 = new Member();
        member2.setName("민둔둔");

        // When
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        // try {
        //     memberService.join(member2);
        //     fail();
        // } catch (IllegalStateException e) {
        //     assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        // }
        


        // Then

    }
}

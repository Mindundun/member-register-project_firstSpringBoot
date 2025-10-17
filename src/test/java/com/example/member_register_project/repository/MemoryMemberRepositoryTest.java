package com.example.member_register_project.repository;


import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.member_register_project.domain.Member;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void testSave() {
        Member member = new Member();
        member.setName("Mindun");

        repository.save(member);

        // 검증
        Member result = repository.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
    }

    @Test
    void testFindById() {

    }

    @Test
    void testFindByName() {
        Member member1 = new Member();
        member1.setName("Mindun1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Mindun2");
        repository.save(member2);

        Member result = repository.findByName("Mindun1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    void testFindAll() {
        Member member1 = new Member();
        member1.setName("Mindun1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Mindun2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result).hasSize(2);

    }

    

}

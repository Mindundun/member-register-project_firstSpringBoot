package com.example.member_register_project.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.member_register_project.domain.Member;

public class MemoryMemberRepository implements MemberRepository{

    // 회원번호 Long형, Member 객체
    private static Map<Long, Member> store = new HashMap<>();
    
    // key 값을 생성함. 실무에선 동시성 문제 발생
    private static Long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                            .filter(member -> member.getName().equals(name))
                            .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    
    public void clearStore(){
        store.clear();
    }
}

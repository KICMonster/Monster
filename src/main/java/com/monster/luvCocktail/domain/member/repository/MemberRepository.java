package com.monster.luvCocktail.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.monster.luvCocktail.domain.member.entity.Member;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
    Optional<Member> findById(Long id); // 멤버 아이디로 회원 검색
    void deleteByEmail(String email); // 이메일을 기준으로 회원 삭제
}
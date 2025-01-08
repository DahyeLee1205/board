package com.example.member.repository;

import com.example.board.entity.Board;
import com.example.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByLoginId(String loginId);
}

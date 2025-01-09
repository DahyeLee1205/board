package com.example.board;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import com.example.common.entity.Status;
import com.example.member.entity.Gender;
import com.example.member.entity.Member;
import com.example.member.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BoardApplicationTests {
/*
    @Autowired
    BoardRepository boardRepository;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void saveBoard() {
        Board saveParams = Board.builder()
                .boardTitle("테스트1")
                .boardContent("안녕하세요")
                .userNo("1")
                .build();

        Board board = boardRepository.save(saveParams);
        Assertions.assertEquals(board.getBoardTitle(), "테스트1");
    }

    @Test
    void findAllBoard(){
        boardRepository.findAll();
    }

    @Test
    void findBoardById(){
        Board board = boardRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException());
        Assertions.assertEquals(board.getBoardTitle(), "테스트1");
    }

    @Test
    void saveMember() {
        Member saveParams = Member.builder()
                .loginId("dhlee001")
                .password("password")
                .userName("이다혜")
                .email("dhlee001@gmail.com")
                .gen(Gender.F)
                .birthday("19961205")
                .cellPhone("01011111111")
                .status(Status.ACTIVE)
                .build();

        Member member = memberRepository.save(saveParams);
        Assertions.assertEquals(member.getLoginId(), "dhlee001");
    }

    @Test
    void findAllMember(){memberRepository.findAll();}

    @Test
    void findMemberById(){
        Member member = memberRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException());
        Assertions.assertEquals(member.getLoginId(), "dhlee001");
    }*/

}

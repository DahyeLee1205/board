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
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class BoardApplicationTests @Autowired constructor (private val boardRepository : BoardRepository, private val memberRepository : MemberRepository){

    @Test
    fun saveBoard() {
        var saveParams : Board = Board.create(
                boardTitle = "테스트1",
                boardContent = "안녕하세요",
                userNo = "1"
        )
        var board = boardRepository.save(saveParams)
        Assertions.assertEquals(board.boardTitle, "테스트1")
    }

    @Test
    fun findAllBoard(){
        var list = boardRepository.findAll()
        for(item in list)
            println("item : ${item.id}")
    }

        @Test
        fun findBoardById(){
            var board = boardRepository.findById(1L).orElse(null) ?: throw EntityNotFoundException()
            Assertions.assertEquals(board.boardTitle, "테스트1")
            println("id : ${board.id}" + ", title : ${board.boardTitle}, content : ${board.boardContent}")
        }

        @Test
        fun saveMember() {
            var saveParams = Member.create(
                    loginId = "dhlee001",
                    password = "password",
                    userName = "이다혜",
                    email = "dhlee001@gmail.com",
                    gen = Gender.F,
                    birthday = "19961205",
                    cellPhone = "01011111111",
                    status = Status.ACTIVE
            )
            var member = memberRepository.save(saveParams)
            Assertions.assertEquals(member.loginId, "dhlee001");
            println("memberId : ${member.loginId}")
        }

         @Test
         fun findAllMember(){
             var list = memberRepository.findAll();
             for(member in list)
                println("no : ${member.userNo}, name : ${member.userName}")
        }

         @Test
         fun findMemberById(){
             var member = memberRepository.findById(1L).orElse(null) ?:  throw EntityNotFoundException()
             Assertions.assertEquals(member.loginId, "dhlee002")
             println("no : ${member.userNo}, name : ${member.userName}")
         }

}

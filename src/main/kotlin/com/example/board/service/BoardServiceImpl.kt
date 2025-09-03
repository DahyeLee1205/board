package com.example.board.service

import com.example.board.dto.BoardDto
import com.example.board.dto.BoardUpdateDto
import com.example.board.entity.Board
import com.example.board.repository.BoardRepository
import com.example.common.entity.BaseResponse
import lombok.RequiredArgsConstructor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import java.util.List

@Service
@RequiredArgsConstructor
@Transactional
class BoardServiceImpl(private val boardRepository : BoardRepository) : BoardService{

    companion object{
        private val logger : Logger = LoggerFactory.getLogger(BoardServiceImpl::class.java)
    }

    override fun getLatestBoards() : BaseResponse<List<Board>>{
        return try{
            val boards : List<Board> = boardRepository.findTop4ByDelYnOrderByCreateDateDesc(0) // delYn이 0인 게시글 4개
            BaseResponse.success(boards)
        } catch (e :Exception){
            logger.error("e = ${e.message}")
            BaseResponse.error("게시글 목록을 가져오는 데에 실패했습니다.")
        }
    }

    override fun findAll(pageNo : Int, pageSize : Int) : BaseResponse<Page<Board>>{
        return try{
            val pagable : Pageable = PageRequest.of(pageNo, pageSize);
            val boardPage : Page<Board> = boardRepository.findByDelYn(0, pagable);
            return BaseResponse.success(boardPage)
        }catch (e : Exception){
            logger.error("e = ${e.message}")
            return BaseResponse.error("게시글 목록을 가져오는 데에 실패했습니다.");
        }
    }

    override fun getBoardDetail(boardNo : Int) : BaseResponse<Board> {
        return try{
            val board : Board = boardRepository.findByIdAndDelYn(boardNo, 0)
            return BaseResponse.success(board)
        }catch(e : Exception){
            logger.error("e = ${e.message}");
            return BaseResponse.error("게시글을 가져오는 데에 실패했습니다.");
        }
    }

    override fun saveBoard(boardDto : BoardDto) : ResponseEntity<String> {
         var saveParams : Board = Board.create(
                boardTitle = boardDto.boardTitle ?: "",
                boardContent = boardDto.boardContent ?: "",
                userNo = boardDto.userNo ?: ""
         )

        boardRepository.save(saveParams)
        return ResponseEntity.ok("Board saved successfully!")
    }

    override fun updateBoard(boardDto : BoardUpdateDto, id : Long) : ResponseEntity<String> {
        // 엔티티 조회
        val findBoard = boardRepository.findByIdOrNull(id) ?: return ResponseEntity.notFound().build()

        findBoard.updateBoard(
                boardDto.boardTitle ?: findBoard.boardTitle,
                boardDto.boardContent ?: findBoard.boardContent
        )
        boardRepository.save(findBoard);

        return ResponseEntity.ok("Board updated successfully!");
    }

    override fun deleteBoard(id : Long) : ResponseEntity<String> {
        // 엔티티 조회
        val findBoard = boardRepository.findByIdOrNull(id)
                ?: return ResponseEntity.notFound().build() // 404 처리

        boardRepository.delete(findBoard)
        return ResponseEntity.ok("Board deleted successfully!");
    }
}

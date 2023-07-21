package board.demo.controller;


import board.demo.dto.BoardDto;
import board.demo.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 게시글 목록 조회
    @GetMapping
    private List<BoardDto> findAllBoard() {
        return this.boardService.getAllBoards();
    }


    // 게시글 상세 조회
    @GetMapping("/{boardId}")
    private BoardDto findBoardById(@PathVariable Integer boardId) {
        return this.boardService.getBoardById(boardId);
    }

    // 게시글 등록
    @PostMapping
    private void createBoard(@RequestBody BoardDto dto) {
        this.boardService.createBoard(dto);
    }

    // 게시글 수정
    @PutMapping("/{boardId}")
    private void editBoard(@PathVariable Integer boardId, @RequestBody BoardDto dto) {
        this.boardService.modifyBoard(boardId, dto);
    }


    // 게시글 삭제
    @DeleteMapping("/{boardId}")
    private void deleteBoard(@PathVariable Integer boardId) {
        this.boardService.removeBoard(boardId);
    }

    // 내가 쓴 모든 게시글 조회



}

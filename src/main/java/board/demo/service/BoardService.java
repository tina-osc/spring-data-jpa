package board.demo.service;

import board.demo.dto.BoardDto;
import board.demo.entity.Board;
import board.demo.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    private final BoardRepository boardRepository;

    // 게시판 목록 조회
    public List<BoardDto> getAllBoards() {
        List<Board> boardList = this.boardRepository.findAll();

        if (boardList.isEmpty()) {
            return null;
        }

        List<BoardDto> dtoList = new ArrayList<BoardDto>();

        for (Board board : boardList) {
            BoardDto dto = BoardDto.builder()
                    .boardId(board.getBoardId())
                    .title(board.getTitle())
                    .content(board.getContent())
                    .writerId(board.getWriterId())
                    .writerName(board.getWriter().getName())
                    .build();

            dtoList.add(dto);
        }
        return dtoList;
    }

    // 게시판 상세 조회
    public BoardDto getBoardById(Integer boardId) {
        Board board = this.boardRepository.findById(boardId).get();

        if (board == null) {
            return null;
        }

        BoardDto dto = BoardDto.builder()
                .boardId(board.getBoardId())
                .title(board.getTitle())
                .content(board.getContent())
                .writerId(board.getWriterId())
                .writerName(board.getWriter().getName())
                .writerEmail(board.getWriter().getEmail())
                .writerGender(board.getWriter().getGender())
                .editorId(board.getEditorId())
                .editorName(board.getEditor().getName())
                .editorEmail(board.getEditor().getEmail())
                .editorGender(board.getEditor().getGender())
                .build();

        return dto;
    }


    // 게시판 등록
    public void createBoard(BoardDto dto) {
        this.boardRepository.save(dto.toEntity());
    }


    // 게시판 수정
    @Transactional
    public void modifyBoard(Integer boardId, BoardDto dto) {
        Board before = this.boardRepository.findById(boardId).get();

        Board board = Board.builder()
                .boardId(boardId)
                .title(dto.getTitle())
                .content(dto.getContent())
                .writerId(before.getWriterId())
                .editorId(dto.getEditorId())
//                .editorId(dto.getEditorName())
                .build();

        this.boardRepository.save(board);
    }


    // 게시판 삭제
    @Transactional
    public void removeBoard(Integer boardId) {
        this.boardRepository.deleteById(boardId);
    }


}

package board.demo.dto;


import board.demo.entity.Board;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {

    private Integer boardId;
    private String title;
    private String content;
    private Integer writerId;
    private String writerName;
    private String writerEmail;
    private Integer writerGender;
    private Integer editorId;
    private String editorName;
    private String editorEmail;
    private Integer editorGender;


    @Builder
    public BoardDto (Integer boardId,
                     String title,
                     String content,
                     Integer writerId,
                     String writerName,
                     String writerEmail,
                     Integer writerGender,
                     Integer editorId,
                     String editorName,
                     String editorEmail,
                     Integer editorGender) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.writerId = writerId;
        this.writerName = writerName;
        this.writerEmail = writerEmail;
        this.writerGender = writerGender;
        this.editorId = editorId;
        this.editorName = editorName;
        this.editorEmail = editorEmail;
        this.editorGender = editorGender;
    }

    public Board toEntity() {
        Board board = Board.builder().boardId(this.boardId)
                .title(this.title)
                .content(this.content)
                .writerId(this.writerId)
                .build();
        return board;
    }
}

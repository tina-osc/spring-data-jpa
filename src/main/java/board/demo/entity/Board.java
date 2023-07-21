package board.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "board")
public class Board {


    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardId; // 게시글id

    private String title; // 제목

    private String content; // 내용

    @ManyToOne
    @JoinColumn(name = "writer", insertable = false, updatable = false) //컬럼명
    private User writer; // 작성자

    @ManyToOne
    @JoinColumn(name = "editor", insertable = false, updatable = false)
    private User editor; // 수정자

    @Setter
    @Column(name = "writer")
    private Integer writerId;

    @Setter
    @Column(name = "editor")
    private Integer editorId;

    @Builder
    public Board(Integer boardId,
                 String title,
                 String content,
                 Integer writerId,
                 Integer editorId) {
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.writerId = writerId;
        this.editorId = editorId;
    }
}

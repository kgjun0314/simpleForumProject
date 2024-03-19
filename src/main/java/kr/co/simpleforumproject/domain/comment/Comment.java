package kr.co.simpleforumproject.domain.comment;

import jakarta.persistence.*;
import kr.co.simpleforumproject.domain.feed.Feed;
import kr.co.simpleforumproject.presentation.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(columnDefinition = "TEXT")
    private String commentContent;

    private LocalDateTime commentCreateData;

    private Long feedId;

    public Comment(CommentRequestDto commentRequestDto, Long feedId) {
        this.commentContent = commentRequestDto.getCommentContent();
        this.commentCreateData = LocalDateTime.now();
        this.feedId = feedId;
    }
}

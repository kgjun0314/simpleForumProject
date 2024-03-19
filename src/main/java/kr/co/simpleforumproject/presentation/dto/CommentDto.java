package kr.co.simpleforumproject.presentation.dto;

import jakarta.persistence.Column;
import kr.co.simpleforumproject.domain.comment.Comment;
import kr.co.simpleforumproject.domain.feed.Feed;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CommentDto {
    private Long commentId;
    private String commentContent;
    private LocalDateTime commentCreateData;
    private Long feedId;

    public static CommentDto toDto(Comment comment) {
        CommentDto feedDto = new CommentDto(
                comment.getCommentId(),
                comment.getCommentContent(),
                comment.getCommentCreateData(),
                comment.getFeedId()
        );

        return feedDto;
    }
}

package kr.co.simpleforumproject.presentation.dto;

import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import kr.co.simpleforumproject.domain.comment.Comment;
import kr.co.simpleforumproject.domain.feed.Feed;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CommentResponseDto {
    private Long commentId;
    private String commentContent;
    private LocalDateTime feedCreateData;
    private Long feedId;

    public static CommentResponseDto toDto(Comment comment) {
        CommentResponseDto commentResponseDto = new CommentResponseDto(
                comment.getCommentId(),
                comment.getCommentContent(),
                comment.getCommentCreateData(),
                comment.getFeedId()
        );

        return commentResponseDto;
    }
}

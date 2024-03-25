package kr.co.simpleforumproject.presentation.dto;

import kr.co.simpleforumproject.domain.comment.Comment;
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
    private LocalDateTime commentCreatedDate;

    public static CommentDto toDto(Comment comment) {
        CommentDto commentDto = new CommentDto(
                comment.getCommentId(),
                comment.getCommentContent(),
                comment.getCommentCreatedDate()
        );
        return commentDto;
    }
}

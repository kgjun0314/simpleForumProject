package kr.co.simpleforumproject.presentation.dto;

import kr.co.simpleforumproject.domain.comment.Comment;
import kr.co.simpleforumproject.domain.feed.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PostDto {
    private Long postId;
    private String postSubject;
    private String postContent;
    private LocalDateTime postCreatedDate;
    private List<CommentDto> postCommentList;

    public static PostDto toDto(Post post) {
        PostDto postDto = new PostDto(
                post.getPostId(),
                post.getPostSubject(),
                post.getPostContent(),
                post.getPostCreatedDate(),
                post.getPostCommentList().stream().
                        map(comment -> CommentDto.toDto(comment))
                        .toList()
        );
        return postDto;
    }
}

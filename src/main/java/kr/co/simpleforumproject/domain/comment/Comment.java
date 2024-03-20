package kr.co.simpleforumproject.domain.comment;

import jakarta.persistence.*;
import kr.co.simpleforumproject.domain.feed.Post;
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

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(CommentRequestDto commentRequestDto, Post post) {
        this.commentContent = commentRequestDto.getCommentContent();
        this.commentCreateData = LocalDateTime.now();
        this.post = post;
    }
}

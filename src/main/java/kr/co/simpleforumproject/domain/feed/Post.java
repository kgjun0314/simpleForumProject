package kr.co.simpleforumproject.domain.feed;

import jakarta.persistence.*;
import kr.co.simpleforumproject.domain.comment.Comment;
import kr.co.simpleforumproject.presentation.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(length = 200)
    private String postSubject;

    @Column(columnDefinition = "TEXT")
    private String postContent;

    private LocalDateTime postCreatedDate;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> postCommentList;


    public Post(PostRequestDto postRequestDto) {
        this.postSubject = postRequestDto.getPostSubject();
        this.postContent = postRequestDto.getPostContent();
        this.postCreatedDate = LocalDateTime.now();
        this.postCommentList = new ArrayList<>();
    }
}

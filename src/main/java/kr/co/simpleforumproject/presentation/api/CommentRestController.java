package kr.co.simpleforumproject.presentation.api;

import kr.co.simpleforumproject.application.CommentService;
import kr.co.simpleforumproject.application.PostService;
import kr.co.simpleforumproject.presentation.dto.CommentDto;
import kr.co.simpleforumproject.presentation.dto.CommentRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/comment")
@AllArgsConstructor
@RestController
public class CommentRestController {
    private CommentService commentService;
    private PostService postService;

    @PostMapping("/create/{postId}")
    public CommentDto createComment(@RequestBody CommentRequestDto commentRequestDto, @PathVariable Long postId) {
        return commentService.createComment(commentRequestDto, postId);
    }
}

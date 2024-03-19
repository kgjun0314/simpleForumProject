package kr.co.simpleforumproject.presentation;

import kr.co.simpleforumproject.application.CommentService;
import kr.co.simpleforumproject.application.FeedService;
import kr.co.simpleforumproject.presentation.dto.CommentDto;
import kr.co.simpleforumproject.presentation.dto.CommentRequestDto;
import kr.co.simpleforumproject.presentation.dto.CommentResponseDto;
import kr.co.simpleforumproject.presentation.dto.FeedResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/comment")
@AllArgsConstructor
@RestController
public class CommentRestController {
    private CommentService commentService;
    private FeedService feedService;

    @PostMapping("/create/{feedId}")
    public ResponseEntity<CommentResponseDto> createComment(@RequestBody CommentRequestDto commentRequestDto, @PathVariable Long feedId) {
        CommentResponseDto commentResponseDto = commentService.createComment(commentRequestDto, feedId);

        return ResponseEntity.ok(commentResponseDto);
    }

    @GetMapping("/{feedId}")
    public List<CommentDto> findComments(@PathVariable Long feedId) {
        return commentService.findCommentsByFeedId(feedId);
    }
}

package kr.co.simpleforumproject.presentation;

import kr.co.simpleforumproject.application.CommentService;
import kr.co.simpleforumproject.application.FeedService;
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
    private FeedService feedService;

    @PostMapping("/create/{feedId}")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentRequestDto commentRequestDto, @PathVariable Long feedId) {
        CommentDto commentDto = commentService.createComment(commentRequestDto, feedId);

        return ResponseEntity.ok(commentDto);
    }

    @GetMapping("/{feedId}")
    public List<CommentDto> findComments(@PathVariable Long feedId) {
        return commentService.findCommentsByFeedId(feedId);
    }
}

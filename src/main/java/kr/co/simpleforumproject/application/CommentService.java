package kr.co.simpleforumproject.application;

import kr.co.simpleforumproject.domain.comment.Comment;
import kr.co.simpleforumproject.domain.feed.Feed;
import kr.co.simpleforumproject.infrastructure.CommentRepository;
import kr.co.simpleforumproject.infrastructure.FeedRepository;
import kr.co.simpleforumproject.presentation.dto.CommentDto;
import kr.co.simpleforumproject.presentation.dto.CommentRequestDto;
import kr.co.simpleforumproject.presentation.dto.CommentResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CommentService {
    private FeedRepository feedRepository;
    private CommentRepository commentRepository;

    public CommentResponseDto createComment(CommentRequestDto commentRequestDto, Long feedId) {
        Optional<Feed> of = feedRepository.findById(feedId);
        Feed feed = null;
        if(of.isPresent()) {
            feed = of.get();
            Comment comment = new Comment(commentRequestDto, feed.getFeedId());
            commentRepository.save(comment);
            CommentResponseDto commentResponseDto = CommentResponseDto.toDto(comment);
            return commentResponseDto;
        } else {
            return null;
        }
    }

    public List<CommentDto> findCommentsByFeedId(Long feedId) {
        List<Comment> oc = commentRepository.findAllByFeedId(feedId);
        List<CommentDto> commentDtos = oc.stream()
                .map(comment -> CommentDto.toDto(comment))
                .toList();
        return commentDtos;
    }
}

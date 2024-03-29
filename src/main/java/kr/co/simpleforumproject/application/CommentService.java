package kr.co.simpleforumproject.application;

import kr.co.simpleforumproject.domain.comment.Comment;
import kr.co.simpleforumproject.domain.exception.DataNotFoundException;
import kr.co.simpleforumproject.domain.feed.Post;
import kr.co.simpleforumproject.infrastructure.CommentRepository;
import kr.co.simpleforumproject.infrastructure.PostRepository;
import kr.co.simpleforumproject.presentation.dto.CommentDto;
import kr.co.simpleforumproject.presentation.dto.CommentRequestDto;
import kr.co.simpleforumproject.presentation.dto.PostDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CommentService {
    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentDto createComment(CommentRequestDto commentRequestDto, Long postId) {
        Post post = null;
        Optional<Post> op = postRepository.findById(postId);
        if(op.isPresent()) {
            post = op.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
        Comment comment = new Comment(commentRequestDto, post);
        commentRepository.save(comment);
        CommentDto commentDto = CommentDto.toDto(comment);
        return commentDto;
    }
}

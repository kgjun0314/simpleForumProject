package kr.co.simpleforumproject.application;

import kr.co.simpleforumproject.domain.exception.DataNotFoundException;
import kr.co.simpleforumproject.domain.feed.Post;
import kr.co.simpleforumproject.infrastructure.PostRepository;
import kr.co.simpleforumproject.presentation.dto.PostDto;
import kr.co.simpleforumproject.presentation.dto.PostRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PostService {
    private PostRepository postRepository;

    public PostDto createPost(PostRequestDto postRequestDto) {
        Post post = new Post(postRequestDto);
        postRepository.save(post);
        PostDto postDto = PostDto.toDto(post);
        return postDto;
    }

    public List<PostDto> findAll() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = posts.stream()
                .map(post -> PostDto.toDto(post))
                .toList();
        return postDtos;
    }

    public PostDto getPost(Long postId) {
        Optional<Post> op = postRepository.findById(postId);
        if(op.isPresent()) {
            return PostDto.toDto(op.get());
        } else {
            throw new DataNotFoundException("question not found");
        }
    }
}

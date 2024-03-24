package kr.co.simpleforumproject.presentation.api;

import kr.co.simpleforumproject.application.PostService;
import kr.co.simpleforumproject.presentation.dto.PostDto;
import kr.co.simpleforumproject.presentation.dto.PostRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/post")
@AllArgsConstructor
@RestController
public class PostRestController {
    private PostService postService;
    @PostMapping("/create")
    public PostDto createPost(@RequestBody PostRequestDto postRequestDto){
        return postService.createPost(postRequestDto);
    }

    @GetMapping("/list")
    public List<PostDto> listPost(){
        return postService.findAll();
    }

    @GetMapping("/detail/{postId}")
    public PostDto getPost(@PathVariable Long postId){
        return PostDto.toDto(postService.getPost(postId));
    }
}

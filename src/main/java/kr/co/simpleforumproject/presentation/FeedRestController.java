package kr.co.simpleforumproject.presentation;

import kr.co.simpleforumproject.application.FeedService;
import kr.co.simpleforumproject.presentation.dto.FeedDto;
import kr.co.simpleforumproject.presentation.dto.FeedRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/feed")
@AllArgsConstructor
@RestController
public class FeedRestController {
    private FeedService feedService;
    @PostMapping("/create")
    public ResponseEntity<FeedDto> createFeed(@RequestBody FeedRequestDto feedRequestDto){
        FeedDto feedDto = feedService.createFeed(feedRequestDto);

        return ResponseEntity.ok(feedDto);
    }

    @GetMapping("/list")
    public List<FeedDto> findFeeds() {
        return feedService.findAll();
    }
}

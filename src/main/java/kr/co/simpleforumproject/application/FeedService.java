package kr.co.simpleforumproject.application;

import kr.co.simpleforumproject.domain.feed.Feed;
import kr.co.simpleforumproject.infrastructure.FeedRepository;
import kr.co.simpleforumproject.presentation.dto.FeedDto;
import kr.co.simpleforumproject.presentation.dto.FeedRequestDto;
import kr.co.simpleforumproject.presentation.dto.FeedResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FeedService {
    private FeedRepository feedRepository;

    public FeedResponseDto createFeed(FeedRequestDto feedRequestDto) {
        Feed feed = new Feed(feedRequestDto);
        feedRepository.save(feed);
        FeedResponseDto feedResponseDto = FeedResponseDto.toDto(feed);
        return feedResponseDto;
    }

    public List<FeedDto> findAll() {
        List<Feed> feeds = feedRepository.findAll();
        List<FeedDto> feedDtos = feeds.stream()
                .map(feed -> FeedDto.toDto(feed))
                .toList();
        return feedDtos;
    }
}

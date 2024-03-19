package kr.co.simpleforumproject.presentation.dto;

import kr.co.simpleforumproject.domain.feed.Feed;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class FeedResponseDto {
    private Long feedId;
    private String feedSubject;
    private String feedContent;
    private LocalDateTime feedCreateDate;

    public static FeedResponseDto toDto(Feed feed) {
        FeedResponseDto feedResponseDto = new FeedResponseDto(
                feed.getFeedId(),
                feed.getFeedSubject(),
                feed.getFeedContent(),
                feed.getFeedCreateDate()
        );

        return feedResponseDto;
    }
}

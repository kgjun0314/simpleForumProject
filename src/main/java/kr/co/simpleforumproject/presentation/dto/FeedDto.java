package kr.co.simpleforumproject.presentation.dto;

import kr.co.simpleforumproject.domain.feed.Feed;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class FeedDto {
    private Long feedId;
    private String feedSubject;
    private String feedContent;
    private LocalDateTime feedCreateDate;

    public static FeedDto toDto(Feed feed) {
        FeedDto feedDto = new FeedDto(
                feed.getFeedId(),
                feed.getFeedSubject(),
                feed.getFeedContent(),
                feed.getFeedCreateDate()
        );

        return feedDto;
    }
}

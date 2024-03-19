package kr.co.simpleforumproject.domain.feed;

import jakarta.persistence.*;
import kr.co.simpleforumproject.presentation.dto.FeedRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedId;

    @Column(length = 200)
    private String feedSubject;

    @Column(columnDefinition = "TEXT")
    private String feedContent;

    private LocalDateTime feedCreateDate;

    public Feed(FeedRequestDto feedRequestDto) {
        this.feedSubject = feedRequestDto.getFeedSubject();
        this.feedContent = feedRequestDto.getFeedContent();
        this.feedCreateDate = LocalDateTime.now();
    }
}

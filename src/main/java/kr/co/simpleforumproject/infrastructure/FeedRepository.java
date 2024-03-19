package kr.co.simpleforumproject.infrastructure;

import kr.co.simpleforumproject.domain.feed.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRepository extends JpaRepository<Feed, Long> {

}

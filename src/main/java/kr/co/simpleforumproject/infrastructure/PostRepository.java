package kr.co.simpleforumproject.infrastructure;

import kr.co.simpleforumproject.domain.feed.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}

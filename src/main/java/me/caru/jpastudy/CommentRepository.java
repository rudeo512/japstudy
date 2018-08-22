package me.caru.jpastudy;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * CommentRepository
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 21.
 */
public interface CommentRepository extends MyRepository<Comment, Long> {
	List<Comment> findByContentContains(@NotBlank String content);

	List<Comment> findByContentContainsIgnoreCase(@NotBlank String content);

	List<Comment> findByContentContainsIgnoreCaseAndLikeCountGreaterThan(@NotBlank String content, Integer likeCount);

	Page<Comment> findByLikeCountGreaterThanAndPost(Pageable pageable, int likeCount, Post post);
}

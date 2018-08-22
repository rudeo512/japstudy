package me.caru.jpastudy.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import me.caru.jpastudy.repository.CustomJpaRepository;

/**
 * PostRepository
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 21.
 */
public interface PostRepository extends CustomJpaRepository<Post, Long> {
	Page<Post> findByTitleContains(String title, Pageable pageable);

	long countByTitleContains(String title);
}

package me.caru.jpastudy.post;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;

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

	List<Post> findByTitleStartingWith(@NotBlank String title);

	@Query("SELECT p FROM Post as p where p.title = ?1")
	List<Post> findByTitle(@NotBlank String title, Sort sort);
}

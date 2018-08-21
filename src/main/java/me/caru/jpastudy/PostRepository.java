package me.caru.jpastudy;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * PostRepository
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 21.
 */
public interface PostRepository extends JpaRepository<Post, Long> {
	Page<Post> findByTitleContains(String title, Pageable pageable);
	long countByTitleContains(String title);
}

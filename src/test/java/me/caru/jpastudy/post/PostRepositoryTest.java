package me.caru.jpastudy.post;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.test.annotation.Rollback;

import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import me.caru.jpastudy.RepositoryTest;

/**
 * PostRepositoryTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 21.
 */

@Slf4j
public class PostRepositoryTest extends RepositoryTest {

	@Autowired
	private PostRepository postRepository;

	@Test
	@Rollback(false)
	public void crudRepository() {
		// Given
		Post post = new Post("hello spring boot common");
		assertThat(post.getId()).isNull();

		// When
		Post newPost = postRepository.save(post);
		// Then
		assertThat(newPost.getId()).isNotNull();

		// When
		List<Post> posts = postRepository.findAll();
		// Then
		assertThat(posts.size()).isEqualTo(1);
		assertThat(posts).contains(newPost);

		// When
		Page<Post> page = postRepository.findAll(PageRequest.of(0, 10));
		// Then
		assertThat(page.getTotalElements()).isEqualTo(1);
		assertThat(page.getNumber()).isEqualTo(0);
		assertThat(page.getSize()).isEqualTo(10);
		assertThat(page.getNumberOfElements()).isEqualTo(1);

		// When
		page = postRepository.findByTitleContains("spring", PageRequest.of(0, 10));
		// Then
		assertThat(page.getTotalElements()).isEqualTo(1);
		assertThat(page.getNumber()).isEqualTo(0);
		assertThat(page.getSize()).isEqualTo(10);
		assertThat(page.getNumberOfElements()).isEqualTo(1);

		// When
		long count = postRepository.countByTitleContains("spring");
		// Then
		assertThat(count).isEqualTo(1);
	}

	@Test
	public void customJpaReposity() {
		Post post = new Post("hibernate");

		assertThat(postRepository.contains(post)).isFalse();

		postRepository.save(post);

		assertThat(postRepository.contains(post)).isTrue();
	}

	@Test
	public void event() {
		Post post = new Post("hibernate");
		postRepository.save(post.publish());
		postRepository.flush();
	}

	@Test
	public void dsl() {
		Post post = new Post("hibernate");
		postRepository.save(post);

		Predicate predicate = QPost.post.title.containsIgnoreCase("Hi");
		Optional<Post> one = postRepository.findOne(predicate);
		assertThat(one).isNotEmpty();
	}

	@Test
	public void findByTitleStartingWith1() {
		Post post = new Post("hibernate good nice!");
		postRepository.save(post);
		List<Post> posts = postRepository.findByTitleStartingWith("hib");
		assertThat(posts.size()).isEqualTo(1);
	}

	@Test(expected = InvalidDataAccessApiUsageException.class)
	public void findByTitleStartingWith2() {
		Post post = new Post("hibernate good nice!");
		postRepository.save(post);
		List<Post> posts = postRepository.findByTitleStartingWith(null);
		assertThat(posts.size()).isEqualTo(0);
	}

	@Test
	public void findByTitle() {
		Post post = new Post("nice!");
		postRepository.save(post);
		List<Post> posts = postRepository.findByTitle("nice!", JpaSort.unsafe(Sort.Direction.DESC, "LENGTH(title)"));
		log.info("posts = {}", posts);
		assertThat(posts.size()).isEqualTo(1);
	}
}
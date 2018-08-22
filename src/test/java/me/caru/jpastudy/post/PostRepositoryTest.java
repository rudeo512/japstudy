package me.caru.jpastudy.post;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;

import me.caru.jpastudy.RepositoryTest;
import me.caru.jpastudy.config.EventListenerConfig;

/**
 * PostRepositoryTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 21.
 */

@Import(EventListenerConfig.class)
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
}
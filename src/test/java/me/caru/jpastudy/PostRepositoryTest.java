package me.caru.jpastudy;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PostRepositoryTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 21.
 */
@RunWith(SpringRunner.class)
@DataJpaTest(showSql = false)
@TestPropertySource(locations = "classpath:test.yml")
public class PostRepositoryTest {

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

}
package me.caru.jpastudy.comment;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.caru.jpastudy.RepositoryTest;

/**
 * CommentRepositoryTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 21.
 */

public class CommentRepositoryTest extends RepositoryTest {

	@Autowired
	private CommentRepository commentRepository;

	@Test
	public void test() {
		commentRepository.save(new Comment("111"));
		List<Comment> comments = commentRepository.findAll();
		assertThat(comments.size()).isEqualTo(1);
	}

	@Test
	public void optional() {
		Optional<Comment> byId = commentRepository.findById(100L);
		assertThat(byId).isEmpty();
	}

	@Test
	public void findByContentContains() {
		Comment comment = new Comment("spring data jpa");
		commentRepository.save(comment);

		List<Comment> comments = commentRepository.findByContentContains("Spring");
		assertThat(comments).isEmpty();
	}

	@Test
	public void findByContentContainsIgnoreCase() {
		Comment comment = new Comment("spring data jpa");
		commentRepository.save(comment);

		List<Comment> comments = commentRepository.findByContentContainsIgnoreCase("Spring");
		assertThat(comments.size()).isEqualTo(1);
	}

	@Test
	public void findByContentContainsIgnoreCaseAndLikeCountGreaterThan() {
		Comment comment = new Comment("spring data jpa");
		comment.setLikeCount(1);
		commentRepository.save(comment);

		List<Comment> comments = commentRepository.findByContentContainsIgnoreCaseAndLikeCountGreaterThan("Spring", 10);
		assertThat(comments).isEmpty();
	}

	@Test
	public void findByContentContainsIgnoreCaseAndLikeCountGreaterThan2() {
		Comment comment = new Comment("spring data jpa");
		comment.setLikeCount(11);
		commentRepository.save(comment);

		List<Comment> comments = commentRepository.findByContentContainsIgnoreCaseAndLikeCountGreaterThan("spring", 10);
		assertThat(comments.size()).isEqualTo(1);
	}
}
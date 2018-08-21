package me.caru.jpastudy;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
}
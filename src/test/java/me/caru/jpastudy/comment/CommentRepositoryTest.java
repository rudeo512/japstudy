package me.caru.jpastudy.comment;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import me.caru.jpastudy.RepositoryTest;
import me.caru.jpastudy.post.Post;
import me.caru.jpastudy.post.PostRepository;

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

	@Autowired
	private PostRepository postRepository;

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

	@Test
	public void projection() {
		Post post = new Post("12213");
		Post savedPost = postRepository.save(post);

		Comment comment = new Comment("comment");
		comment.setPost(savedPost);
		comment.setUp(4);
		comment.setDown(2);
		Comment savedComment = commentRepository.save(comment);

		List<CommentView1> commentView1 = commentRepository.findByPost_id(savedPost.getId(), CommentView1.class);
		assertThat(commentView1.size()).isEqualTo(1);
		commentView1.stream().forEach(c -> {

			System.out.println("========>");
			System.out.println(c.getVote());
		});

		List<CommentView2> commentView2 = commentRepository.findByPost_id(savedPost.getId(), CommentView2.class);
		assertThat(commentView2.size()).isEqualTo(1);

		commentView2.stream().forEach(c -> {
			System.out.println("========>");
			System.out.println(c.getContent());
		});
	}


	@Test
	public void spec() {
		Comment comment = new Comment("comment");
		comment.setBest(true);

		commentRepository.save(comment);
		commentRepository.findAll(CommentSpec.isBest().and(CommentSpec.isGood()));
	}
}
package me.caru.jpastudy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * JpaRunner
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 20.
 */

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Session session = entityManager.unwrap(Session.class);

		Post post = new Post("나는 포스트야");

		Comment comment1 = new Comment("댓글1");
		Comment comment2 = new Comment("댓글2");

		post.addComment(comment1);
		post.addComment(comment2);

		session.save(post);

		Post p1 =session.get(Post.class, 1L);

	}
}

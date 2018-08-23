package me.caru.jpastudy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import me.caru.jpastudy.post.PostRepository;

/**
 * JpaRunner
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 20.
 */

@Component
@Transactional
@RequiredArgsConstructor
public class JpaRunner implements ApplicationRunner {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	final private PostRepository postRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
	}
}

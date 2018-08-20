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

		Account account = new Account("caru", "rudeo512");

		Study study = new Study();
		study.setName("spring data jpa");

		account.addStudy(study);

		session.save(account);
		session.save(study);
	}
}

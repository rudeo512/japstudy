package me.caru.jpastudy;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import me.caru.jpastudy.config.EventListenerConfig;

/**
 * RepositoryTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 21.
 */

@DataJpaTest(showSql = false)
@Import(EventListenerConfig.class)
public abstract class RepositoryTest extends Test {

}

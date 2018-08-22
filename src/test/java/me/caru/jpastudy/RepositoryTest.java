package me.caru.jpastudy;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

/**
 * RepositoryTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 21.
 */

@DataJpaTest(showSql = false)
public abstract class RepositoryTest extends Test {

}

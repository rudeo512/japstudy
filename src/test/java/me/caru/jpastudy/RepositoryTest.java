package me.caru.jpastudy;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * RepositoryTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 21.
 */

@RunWith(SpringRunner.class)
@DataJpaTest(showSql = false)
@TestPropertySource(locations = "classpath:test.yml")
public abstract class RepositoryTest {

}

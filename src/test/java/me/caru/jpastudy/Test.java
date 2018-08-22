package me.caru.jpastudy;

import org.junit.runner.RunWith;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 22.
 */

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:test.yml")
public abstract class Test {
}

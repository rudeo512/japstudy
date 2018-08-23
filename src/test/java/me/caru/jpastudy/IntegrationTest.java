package me.caru.jpastudy;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

/**
 * IntegrationTest
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 23.
 */
@SpringBootTest
@AutoConfigureMockMvc
@Rollback
public abstract class IntegrationTest extends Test {
}

package me.caru.jpastudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;
import me.caru.jpastudy.post.PostListener;

/**
 * EventListenerConfig
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 22.
 */
@Configuration
@Slf4j
public class EventListenerConfig {

	@Bean
	public PostListener postListener() {
		return new PostListener();
	}
}

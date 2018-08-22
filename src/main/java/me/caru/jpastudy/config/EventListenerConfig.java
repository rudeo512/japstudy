package me.caru.jpastudy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;
import me.caru.jpastudy.post.PostPublishedEvent;

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
	@EventListener
	public void onApplicationEvent(PostPublishedEvent event) {
		log.info("PostPublishedEvent event = {}", event.getPost());
	}
}

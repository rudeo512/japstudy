package me.caru.jpastudy.post;

import org.springframework.context.event.EventListener;

import lombok.extern.slf4j.Slf4j;

/**
 * PostListener
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 22.
 */
@Slf4j
public class PostListener {

	@EventListener
	public void onApplicationEvent(PostPublishedEvent event) {
		log.info("PostPublishedEvent event = {}", event.getPost());
	}
}

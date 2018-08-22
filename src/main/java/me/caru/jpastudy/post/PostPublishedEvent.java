package me.caru.jpastudy.post;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

/**
 * PostPublishedEvent
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 22.
 */

@Getter
public class PostPublishedEvent extends ApplicationEvent {

	final private Post post;

	/**
	 * Create a new ApplicationEvent.
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public PostPublishedEvent(Object source) {
		super(source);
		post = (Post)source;
	}
}

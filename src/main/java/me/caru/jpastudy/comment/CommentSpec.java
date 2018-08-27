package me.caru.jpastudy.comment;

import org.springframework.data.jpa.domain.Specification;

/**
 * CommentSpec
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 27.
 */
public class CommentSpec {
	public static Specification<Comment> isBest() {
		return (Specification<Comment>)
			(root, query, builder) -> builder.isTrue(root.get(Comment_.best));
	}

	public static Specification<Comment> isGood() {
		return (Specification<Comment>)
			(root, query, builder) -> builder.greaterThanOrEqualTo(root.get(Comment_.up), 10);
	}
}

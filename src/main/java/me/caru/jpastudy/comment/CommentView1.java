package me.caru.jpastudy.comment;

/**
 * CommentView1
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 26.
 */
public interface CommentView1 {
	String getContent();

	Integer getUp();

	Integer getDown();

	default Integer getVote() {
		return this.getUp() - this.getDown();
	}
}

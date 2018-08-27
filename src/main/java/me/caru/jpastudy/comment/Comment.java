package me.caru.jpastudy.comment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.caru.jpastudy.post.Post;

/**
 * Comment
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 20.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(
	generator = ObjectIdGenerators.PropertyGenerator.class,
	property = "id")
public class Comment {
	@Id
	@GeneratedValue
	private Long id;

	private String content;

	private Integer likeCount = 0;

	private Integer up;
	private Integer down;

	private Boolean best;

	@ManyToOne
	private Post post;

	public Comment(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Comment{" +
			"id=" + id +
			", content='" + content + '\'' +
			", likeCount=" + likeCount +
			", post=" + post +
			'}';
	}
}

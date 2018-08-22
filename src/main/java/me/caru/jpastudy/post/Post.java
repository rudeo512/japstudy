package me.caru.jpastudy.post;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.domain.AbstractAggregateRoot;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import me.caru.jpastudy.comment.Comment;

/**
 * Post
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 20.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Post extends AbstractAggregateRoot<Post> {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	@Lob
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	private Date created;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Comment> comments = new LinkedList<>();

	public Post(String title) {
		this.title = title;
	}

	public void addComment(Comment comment) {
		getComments().add(comment);
		comment.setPost(this);
	}

	public Post publish() {
		this.registerEvent(new PostPublishedEvent(this));
		return this;
	}
}

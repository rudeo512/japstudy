package me.caru.jpastudy;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Post {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Comment> comments = new LinkedList<>();

	public Post(String title) {
		this.title = title;
	}

	public void addComment(Comment comment) {
		getComments().add(comment);
		comment.setPost(this);
	}
}

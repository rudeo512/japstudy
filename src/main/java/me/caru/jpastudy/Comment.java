package me.caru.jpastudy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Comment {
	@Id
	@GeneratedValue
	private Long id;

	private String content;

	@ManyToOne
	private Post post;

	public Comment(String content) {
		this.content = content;
	}
}

package me.caru.jpastudy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

/**
 * Study
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 20.
 */

@Entity
@Getter
@Setter
public class Study {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@ManyToOne
	private Account creator;

}

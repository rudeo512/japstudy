package me.caru.jpastudy;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

/**
 * Account
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 20.
 */
@Entity
@Getter
@Setter
public class Account {
	@Id
	@GeneratedValue
	private Long id;

	private String userId;
	private String password;

	@OneToMany(mappedBy = "creator")
	private Set<Study> studies = new HashSet<>();

	@Embedded
	@AttributeOverrides(
		@AttributeOverride(name = "street", column = @Column(name = "home_street"))
	)
	private Address address;

	public Account(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}

	public void addStudy(Study study) {
		getStudies().add(study);
		study.setCreator(this);
	}
}

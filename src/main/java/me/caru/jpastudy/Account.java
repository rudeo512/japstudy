package me.caru.jpastudy;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
public class Account {
	@Id
	@GeneratedValue
	private Long id;

	private String userId;
	private String password;

	public Account(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
}

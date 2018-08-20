package me.caru.jpastudy;

import javax.persistence.Embeddable;

/**
 * Adress
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 20.
 */
@Embeddable
public class Address {
	private String street;
	private String city;
	private String state;
	private String zipCode;
}

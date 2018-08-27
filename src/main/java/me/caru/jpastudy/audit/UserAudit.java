package me.caru.jpastudy.audit;

import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import me.caru.jpastudy.account.Account;

/**
 * UserAudit
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 27.
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class UserAudit extends DateAudit{

	@CreatedBy
	@ManyToOne
	private Account createdBy;

	@LastModifiedBy
	@ManyToOne
	private Account updatedBy;
}

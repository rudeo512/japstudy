package me.caru.jpastudy.audit;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

/**
 * DateAudit
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 27.
 */

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class DateAudit {
	@CreatedDate
	private LocalDateTime createdDate;

	@LastModifiedDate
	private LocalDateTime modifiedDate;
}

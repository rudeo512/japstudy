package me.caru.jpastudy.account;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;

import lombok.extern.slf4j.Slf4j;

/**
 * AccountAuditorAware
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 27.
 */
@Slf4j
public class AccountAuditorAware implements AuditorAware<Account> {
	@Override
	public Optional<Account> getCurrentAuditor() {
		log.info("=============> AccountAuditorAware");
		return Optional.empty();
	}
}

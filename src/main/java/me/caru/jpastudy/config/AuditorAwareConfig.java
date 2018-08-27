package me.caru.jpastudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.caru.jpastudy.account.AccountAuditorAware;

/**
 * AuditorAwareConfig
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 27.
 */
@Configuration
public class AuditorAwareConfig {
	@Bean
	public AccountAuditorAware accountAuditorAware() {
		return new AccountAuditorAware();
	}
}

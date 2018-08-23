package me.caru.jpastudy.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * MyCustomRepository
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 22.
 */

@NoRepositoryBean
public interface CustomJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T> {
	boolean contains(T entity);
}

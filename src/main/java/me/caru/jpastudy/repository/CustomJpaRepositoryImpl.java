package me.caru.jpastudy.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;

/**
 * MyCustomRepositoryImpl
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 22.
 */
public class CustomJpaRepositoryImpl<T, ID extends Serializable> extends QuerydslJpaRepository<T, ID> implements CustomJpaRepository<T, ID> {
	final private EntityManager entityManager;

	public CustomJpaRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public boolean contains(T entity) {
		return entityManager.contains(entity);
	}
}

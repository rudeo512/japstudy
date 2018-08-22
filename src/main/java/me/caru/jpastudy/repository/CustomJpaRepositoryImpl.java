package me.caru.jpastudy.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

/**
 * MyCustomRepositoryImpl
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 22.
 */
public class CustomJpaRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements CustomJpaRepository<T, ID> {
	private EntityManager entityManager;

	public CustomJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public boolean contains(T entity) {
		return entityManager.contains(entity);
	}

	@Override
	public List<T> findAll() {
		return super.findAll();
	}
}

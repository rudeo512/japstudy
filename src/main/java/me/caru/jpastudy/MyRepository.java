package me.caru.jpastudy;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.lang.Nullable;

/**
 * MyRepository
 *
 * @author kyungdae.cho
 * @version 1.0.0
 * @since 2018. 08. 21.
 */

@NoRepositoryBean
public interface MyRepository<T, ID extends Serializable> extends Repository<T, ID> {

	@NotNull <E extends T> E save(@NotNull E entity);

	List<T> findAll();

	@Nullable
	<E extends T> Optional<E> findById(ID id);
}

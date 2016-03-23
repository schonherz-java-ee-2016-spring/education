package hu.schonhertz.training.blog.dao.impl;

import java.io.Serializable;
import java.util.List;

import hu.schonhertz.training.blog.entity.BaseEntity;

public interface BaseConvertDao<E extends BaseEntity, D extends Serializable> {

	E toEntity(D dto, E entity);

	D toDto(E entity);

	public Long saveEntity(E entity) throws Exception;

	public void updateEntity(E entity) throws Exception;

	public void deleteEntity(Long id) throws Exception;

	public E findEntity(Long id) throws Exception;

	public List<E> findAllEntity() throws Exception;
}

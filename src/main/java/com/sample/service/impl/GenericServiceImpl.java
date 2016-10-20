package com.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sample.dao.GenericDao;
import com.sample.exception.BusinessException;
import com.sample.service.GenericService;

@Service
public abstract class GenericServiceImpl<E, K> implements GenericService<E, K> {
 
	@Autowired
    private GenericDao<E, K> genericDao;
 
    public GenericServiceImpl(GenericDao<E, K> genericDao) {
        this.genericDao=genericDao;
    }
 
    public GenericServiceImpl() {
    }
 
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(E entity) throws BusinessException {
        genericDao.saveOrUpdate(entity);
    }
 
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<E> getAll() throws BusinessException {
        return genericDao.getAll();
    }
 
    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public E get(K id) throws BusinessException {
        return genericDao.find(id);
    }
 
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void add(E entity) throws BusinessException {
        genericDao.add(entity);
    }
 
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(E entity) throws BusinessException {
        genericDao.update(entity);
    }
 
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(E entity) throws BusinessException {
        genericDao.remove(entity);
    }
}

package com.roachf.survey.service.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;

import com.roachf.survey.dao.BaseDao;
import com.roachf.survey.service.BaseService;
import com.roachf.survey.utils.page.Page;

//@Service("baseService")  baseService baseDao 是不需要扫描注入的, 直接实例化它的子类. 否则会多实例化一次基类
public class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {
	
	private Logger logger = Logger.getLogger(BaseServiceImpl.class);

	private BaseDao<T, PK> baseDao;

	public BaseDao<T, PK> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T, PK> baseDao) {
		logger.info("set base dao . . . ");
		this.baseDao = baseDao;
	}

	
	@Override
	public Page<T> getListByPage(Page<T> page, Object parameter) {
		return baseDao.getListByPage(page, parameter);
	}

	@Override
	public T getInfo(PK id) {
		return baseDao.getInfo(id);
	}
	
	@Override
	public T getInfo(Object parameter) {
		return baseDao.getInfo(parameter);
	}

	@Override
	public boolean insert(T entity) {
		return baseDao.insert(entity);
	}

	@Override
	public boolean update(T entity) {
		return baseDao.update(entity);
	}

	@Override
	public boolean delete(PK id) {
		return baseDao.delete(id);
	}

}

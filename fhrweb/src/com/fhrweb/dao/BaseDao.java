package com.fhrweb.dao;

import org.apache.log4j.Logger;
import org.hibernate.*;


import java.lang.reflect.*;
import java.util.*;


public abstract class BaseDao<T, PK extends java.io.Serializable> {
	protected Logger log = Logger.getLogger(this.getClass());
	protected Class<T> entityClass;

	protected BaseDao() {
		Type type = getClass().getGenericSuperclass();
		if(type instanceof ParameterizedType)
			entityClass = (Class<T>) ((ParameterizedType)type).getActualTypeArguments()[0];
	}

	protected abstract Session getSession();

	//淇濆瓨
	public PK add(T po) {
		PK id = (PK)this.getSession().save(po);
		addOperateLog("insert", po);
		return id;
	}

	//鏇存柊
	public void update(T po) {
		getSession().update(po);
		addOperateLog("update", po);
	}

	//鏍规嵁hql璇彞鏇存柊
	public int updateByHql(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		setParameters(query, params);
		return query.executeUpdate();
	}

	//鏍规嵁sql璇彞鏇存柊
	public int updateBySql(String sql, Object... params) {
		Query query = getSession().createSQLQuery(sql);
		setParameters(query, params);
		return query.executeUpdate();
	}

	//鎸夌収涓婚敭鍒犻櫎
	public void deleteById(PK id) {
		delete(getById(id));
	}

	//鎸夌収瀵硅薄鍒犻櫎
	public void delete(T po) {
		if(po==null) return;
		getSession().delete(po);
		addOperateLog("delete", po);
	}

	//閫氳繃涓婚敭鑾峰緱
	public T getById(PK id) {
		return (T) getSession().get(entityClass, id);
	}

	//鏍规嵁涓婚敭鍒ゆ柇鏄惁瀛樺湪
	public boolean exists(PK id) {
		return getById(id) != null;
	}

	//鍒锋柊
	protected void flush() {
		getSession().flush();
	}

	//娓呯悊
	protected void clear() {
		getSession().clear();
	}

	

	//璁剧疆鍙傛暟
	protected void setParameters(Query query, Object[] params) {
		if(params==null) return;
		String x;
		int n = 1;
		for(Object p: params) {
			x = "p"+(n++);
			if(p==null || p instanceof String)
				query.setString(x, (String)p);
			else if(p instanceof Integer)
				query.setInteger(x, (Integer)p);
			else if(p instanceof Long)
				query.setLong(x, (Long)p);
			else if(p instanceof Float)
				query.setFloat(x, (Float)p);
			else if(p instanceof Double)
				query.setDouble(x, (Double)p);
			else if(p instanceof Date)
				query.setTimestamp(x, (Date)p);
			else
				query.setParameter(x, p);
		}
	}

	
	protected void addOperateLog(String op, Object obj) {

	}

}

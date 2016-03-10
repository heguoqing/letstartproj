package com.springapp.persist.dao.impl;

import com.springapp.model.BaseEntity;
import com.springapp.persist.dao.IBaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by guoqing on 2016/3/8 0008.
 */
@Repository
public class BaseDaoImpl extends SqlSessionTemplate implements IBaseDao<BaseEntity> {
    @Autowired
    public BaseDaoImpl(SqlSessionFactory sqlSessionFactory) {
        super(sqlSessionFactory);
    }

    public void add(BaseEntity t)
    {
        this.insert(t.getNameSpace()+".insert",t);
    }

    public void delete(BaseEntity t) {
        this.delete(t.getNameSpace()+".deleteByPrimaryKey",t);
    }

    public void update(BaseEntity t) {
        this.update(t.getNameSpace()+".updateByPrimaryKey",t);
    }

    public void select(BaseEntity t) {
        this.selectOne(t.getNameSpace()+".selectByPrimaryKey",t);
    }
}

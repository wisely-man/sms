package com.demo.dao;

import com.demo.core.common.Paginator;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("baseDao")
public abstract class BaseDao {

    @Autowired
    protected SqlSessionTemplate sql;

    public void setSql(SqlSessionTemplate sql) {
        this.sql = sql;
    }

    public String getNamespace(){
        return "";
    };

    /**
     * 通用分页函数
     *
     * @param countNameSpace
     * @param pageNameSpace
     * @param paginator
     * @return
     */
    public Paginator page(String countNameSpace, String pageNameSpace, Paginator paginator) {
        Integer count = Integer.valueOf(sql.selectOne(getNamespace() + "." + countNameSpace, paginator).toString());
        List result = sql.selectList(getNamespace() + "." + pageNameSpace, paginator);
        paginator.setItems(count);
        paginator.setResults(result);
        return paginator;
    }

}

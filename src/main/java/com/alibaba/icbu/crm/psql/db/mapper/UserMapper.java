package com.alibaba.icbu.crm.psql.db.mapper;

import com.alibaba.icbu.crm.psql.db.object.UserDo;

/**
 * @author hualun.zy
 */
public interface UserMapper {
    /**
     * Find by id user do.
     *
     * @param id the id
     * @return the user do
     */
    UserDo findById(long id);
}

package com.springapp.redis.dao;

import com.springapp.model.User;

/**
 * Created by guoqing on 2016/3/24 0024.
 */
public interface UserDAO {
    User getUser(long id);
    void saveUser(final User user);
}

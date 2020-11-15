package com.sucaisheng.dao;

import com.sucaisheng.domain.User;

import java.util.List;

public interface IUserDao {
    /**
     * 查询所有用户
     * @return
     */
    public List<User> selectAllUser();

    /**
     * 添加用户
     * @param user
     */
    public void addUser(User user);
}

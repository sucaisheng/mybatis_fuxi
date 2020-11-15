package com.sucaisheng.dao;

import com.sucaisheng.domain.User;

import java.util.List;

public interface IUserDao {
    public List<User> selectAllUser();
}

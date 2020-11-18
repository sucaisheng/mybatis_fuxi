package com.sucaisheng.mapper;

import com.sucaisheng.domain.Account;
import com.sucaisheng.domain.User;

import java.util.List;

public interface IUserMapper {
    /**
     * 查询所有用户
     * @return
     */
    public List<User> selectAllUser();

    /**
     * 懒加载查询账户，需要用到用户时将用户也查询出来
     * @return
     */
    public List<Account> selectAllAccount();

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    public User selectUserById(int id);

    /**
     * 根据id查询账户
     * @param id
     * @return
     */
    public List<Account> selectAccountByid(int id);

}

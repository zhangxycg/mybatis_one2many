package com.zxy.dao;

import com.zxy.pojo.Account;
import com.zxy.pojo.AccoutUser;

import java.util.List;

/**
 * @Description:
 * @Author: zhangxy
 * @Date: Created in 2019/11/27
 * @Modified By:
 */
public interface IAccountDao {
    /**
     * 查询所有账户信息
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户，并带用户名称和地址信息
     * @return
     */
    List<AccoutUser> findAllAccount();
}

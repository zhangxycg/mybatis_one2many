package com.zxy.test;

import com.zxy.dao.IAccountDao;
import com.zxy.dao.IUserDao;
import com.zxy.pojo.Account;
import com.zxy.pojo.AccoutUser;
import com.zxy.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 测试mybatis的一对一(因为一个账户信息只能供某个用户使用，
 * 所以从查询账户信息出发关联查询用户信息为一对一查询)
 * @Author: zhangxy
 * @Date: Created in 2019/11/27
 * @Modified By:
 */
public class AccountTest {
    private InputStream input;
    private SqlSession session;
    private IAccountDao accountDao;

    /**
     * 初始化操作
     *
     * @throws Exception
     */
    @Before // 用于在测试方法执行之前执行
    public void init() throws Exception {
        // 1.读取配置文件
        input = Resources.getResourceAsStream("Mybatis-config.xml");
        // 2.获取SqlSessionFactory工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(input);
        // 3.获取SqlSession 对象
        session = factory.openSession();
        // 4.获取dao接口的代理对象
        accountDao = session.getMapper(IAccountDao.class);
    }


    @After // 用于在测试方法执行之后执行
    public void destroy() throws Exception {
        // 提交事务
        session.commit();
        // 释放资源
        session.close();
        input.close();
    }

    /**
     * 测试查询所有账户信息
     */
    @Test
    public void testFindAll() {
        List<Account> accounts = accountDao.findAll();
        for (Account account : accounts) {
            System.out.println("每个account的信息");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void testFindAllAccount() {
        List<AccoutUser> aus = accountDao.findAllAccount();
        for (AccoutUser au : aus) {
            System.out.println(au);
        }
    }
}

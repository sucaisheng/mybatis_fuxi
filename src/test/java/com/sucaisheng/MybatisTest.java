package com.sucaisheng;

import com.sucaisheng.domain.Account;
import com.sucaisheng.mapper.IUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


public class MybatisTest {
    private InputStream resourceAsStream;
    private SqlSession sqlSession;

    @Before
    public void init() throws Exception{
        //获取配置文件
        resourceAsStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        //创建工厂对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取SQLSession对象
        sqlSession = sessionFactory.openSession();
    }

    @After
    public void destroy() throws Exception{
        sqlSession.commit();
        resourceAsStream.close();
        sqlSession.close();
    }

    @Test
    public void selectAccount(){
        //获取dao的代理对象
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        List<Account> accountList = mapper.selectAllAccount();
        for (Account a : accountList){
            System.out.println(a);
        }
    }
}

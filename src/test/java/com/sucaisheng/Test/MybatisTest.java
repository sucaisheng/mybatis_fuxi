package com.sucaisheng.Test;

import com.sucaisheng.dao.IUserDao;
import com.sucaisheng.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;

public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;

    @Before
    public void init() throws Exception{
        //获取配置信息流
        in = Resources.getResourceAsStream("SqlMapperConfig.xml");
        //创建SQLSession工厂
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取SQLSession对象
        sqlSession = factory.openSession();
    }

    @After
    public void destroy() throws Exception{
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void insertTest(){
        User user = new User();
        user.setUsername("su");
        user.setAddress("贵州");
        user.setSex("男");
        user.setBirthday(new Date());
        //获取dao代理对象
        IUserDao mapper = sqlSession.getMapper(IUserDao.class);
        //执行添加用户方法
        mapper.addUser(user);
    }
}

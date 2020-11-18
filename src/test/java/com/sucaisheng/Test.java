package com.sucaisheng;

import com.sucaisheng.mapper.IUserMapper;
import com.sucaisheng.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        //获取配置信息流
        InputStream in = Resources.getResourceAsStream("SqlMapperConfig.xml");
        //获取SqlSessFactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取SQLSession对象
        SqlSession sqlSession = factory.openSession();
        //获取dao的代理对象
        IUserMapper mapper = sqlSession.getMapper(IUserMapper.class);
        //执行查询所有方法
        List<User> userList = mapper.selectAllUser();
        //遍历userList
        for (User user : userList) {
            System.out.println(user);
        }
        //关闭流
        sqlSession.close();
        in.close();
    }
}

/**
 * 功能：
 * 作者：yixiangxi
 * 日期：2024/1/27 20:06
 **/
package com.yixiangxi;
import com.yixiangxi.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
mybatis 的快速入门代码
 */

//快速生成主函数的快捷方式  输入psvm

public class mybatisDemo {
    public static void main(String[] args) throws IOException {
        //1.加载mybatis的核心配置文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行SQL语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.执行sql语句
        List<User> users = sqlSession.selectList("selectall.selectUserAll");
        //4.输出结果
        System.out.println(users);
        //5.关闭sqlSession释放资源
        sqlSession.close();

    }
}

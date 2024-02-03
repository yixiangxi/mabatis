/**
 * 功能：
 * 作者：yixiangxi
 * 日期：2024/1/27 20:06
 **/
package com.yixiangxi;
import com.yixiangxi.pojo.User;
import com.yixiangxi.usermapper.userMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
mybatis 代理开发
 */

//快速生成主函数的快捷方式  输入psvm

public class mybatisDemo3 {
    public static void main(String[] args) throws IOException {
//      接收数据
        String name = "张" ;
        Integer age = 12;

//        处理数据
        name = "%" +name +"%";


//        封装对象
        User user = new User();
        user.setName(name);
//        user.setAge(age);

//        map封装

        Map map = new HashMap();
        map.put("name",name);
        map.put("age",age);



        //1.加载mybatis的核心配置文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象，用它来执行SQL语句
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.执行sql语句
//        List<User> users = sqlSession.selectList("selectall.selectUserAll");


        //3.1获取userMapper代理对象
        userMapper userMapper = sqlSession.getMapper(userMapper.class);

//        使用多值传递
//        List<User> users = userMapper.selectByCondition(name,age);

//        使用对象封装
//        List<User> users = userMapper.selectByCondition(user);

//        使用map封装
        List<User> users = userMapper.selectByCondition(map);

        //4.输出结果
        System.out.println(users);
        //5.关闭sqlSession释放资源
        sqlSession.close();

    }
}

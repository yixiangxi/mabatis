package com.yixiangxi.usermapper;

import com.yixiangxi.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface userMapper {
    //    在 Mapper 接口中定义方法，方法名就是SQL映射文件中sql语句的id，并保持参数类型和返回值类型一致
    List<User> selectUserAll();

    //    条件查询
    User selectUserById(int id);

    //    多值+模糊 条件查询
//    *参数接收
//    1.散装参数接收，使用@Param("sql占位符名称")注解进行标注，说明 String name 对应的是 name字段，将String name传入到xml文件中
//    2.Map集合接收
//    3.JavaBean对象接收:对象的属性名称和占位符名称一致与数据库中表的字段一致。
    List<User> selectByCondition(@Param("name") String name, @Param("age") Integer age);

    List<User> selectByCondition(User user);

    List<User> selectByCondition(Map map);

    List<User> selectByConditionSingle(User user);

}

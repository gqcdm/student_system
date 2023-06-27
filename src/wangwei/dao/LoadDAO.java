package wangwei.dao;

import org.apache.ibatis.annotations.Param;
import wangwei.entity.User;

import java.util.List;

public interface LoadDAO {
    //查询所有
    public List<User> selectAll();
    //根据用户名跟密码查询
    public User selectByNameAndPassword(@Param(value = "name") String name, @Param(value = "pwd") String pwd);
    //根据用户名查询
    public User selectByName(@Param(value = "name")String name);
    //新增信息
    public void insertAll(User user);
}

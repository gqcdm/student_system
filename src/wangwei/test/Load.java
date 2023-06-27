package wangwei.test;
import org.junit.Test;
import wangwei.dao.LoadDAO;
import wangwei.entity.User;
import wangwei.util.MybatisUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Load {
    LoadDAO loadDAO = (LoadDAO) MybatisUtil.getMapper(LoadDAO.class);

    //查询所有
    @Test
    public void selectAll() {
        System.out.println(loadDAO.selectAll());
        MybatisUtil.close();
    }

    // 根据用户名和密码查询
    @Test
    public void selectByNameAndPassword() {
        System.out.println(loadDAO.selectByNameAndPassword("admin","admin"));
        MybatisUtil.close();
    }

    //根据用户名查询
    @Test
    public void selectByName() {
        System.out.println(loadDAO.selectByName("admin"));
        MybatisUtil.close();
    }

    //新增信息
    @Test
    public void insertAll() {
        User user = new User("root","root",new SimpleDateFormat().format(new Date()).toString(),"管理员");
        loadDAO.insertAll(user);
        MybatisUtil.close();
    }
}
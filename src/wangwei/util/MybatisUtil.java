package wangwei.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
        private static SqlSessionFactory ssf;
        //创建线程绑定对象
        private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();//相等于传送带

        static{
            // 1、加载mybatis配置文件
            InputStream is = null;
            try {
                is = Resources.getResourceAsStream("mybatis-config.xml");
                //2、创建SqlSession的工厂对象
                ssf =  new SqlSessionFactoryBuilder().build(is);
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("构建连接工厂对象出现异常");
            }

        }

        //获取连接
        private static SqlSession openSession()  {
            SqlSession sqlSession = tl.get();//从ThreadLocal中是否存在连接对象
            if(sqlSession == null){//判断ThreadLocal中是否存在连接对象
                sqlSession = ssf.openSession();//如果不存在，获取连接
                tl.set(sqlSession);//将连接对象存储到ThreadLocal中
            }
            //3、获取SqlSession对象
            return sqlSession;//如果存在，直接返回
        }

        //获取DAO接口实现类
        public static Object getMapper(Class clazz) {
            //获取连接  通过连接获取实现类对象
            return openSession().getMapper(clazz);
        }

        //关闭连接
        public static void close()  {
            openSession().close();//关闭资源
            tl.remove();//将关闭的资源从ThreadLocal中溢出
        }

        //提交事务
        public static void commit()  {
            openSession().commit();//提交事务
            close();//关闭资源
        }

        //回滚事务
        public static void rollback()  {
            openSession().rollback();//回滚事务
            close();//关闭资源
        }
    }

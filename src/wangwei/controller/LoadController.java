package wangwei.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import wangwei.dao.LoadDAO;
import wangwei.entity.User;
import wangwei.util.MybatisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoadController extends ActionSupport {
    private int id;
    private String name;
    private String pwd;
    private String createDate;
    private String role;
    private String code;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    LoadDAO loadDAO = (LoadDAO) MybatisUtil.getMapper(LoadDAO.class);
    //注册
    public String regist() {
        System.out.println(name + pwd +new SimpleDateFormat().format(new Date())+ role);
        User user = new User(name, pwd,new SimpleDateFormat().format(new Date()),role);
        loadDAO.insertAll(user);
        return "success";
    }
    //登陆
    public String login(){
        System.out.println(name+pwd+code);
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpSession session = request.getSession();
        String storeCode = (String) session.getAttribute("code");
        System.out.println(storeCode);
        return "success";
    }
}

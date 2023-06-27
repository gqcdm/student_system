package wangwei.entity;

public class User {
    private int id;
    private String name;
    private String pwd;
    private String createDate;
    private String role;

    public User() {
    }

    public User(String name, String pwd, String role) {
        this.name = name;
        this.pwd = pwd;
        this.role = role;
    }

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public User(String name, String pwd, String createDate, String role) {
        this.name = name;
        this.pwd = pwd;
        this.createDate = createDate;
        this.role = role;
    }

    public User(int id, String name, String pwd, String createDate, String role) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.createDate = createDate;
        this.role = role;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", createDate='" + createDate + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

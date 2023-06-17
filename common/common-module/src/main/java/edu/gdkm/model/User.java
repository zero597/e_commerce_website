package edu.gdkm.model;

/**
 * 用户类
 */
public class User {
    private Integer uaccount;
    private String upassword;
    private String uname;
    private String usex;

    public User(Integer uaccount, String upassword, String uname, String usex) {
        this.uaccount = uaccount;
        this.upassword = upassword;
        this.uname = uname;
        this.usex = usex;
    }

    public User() {
    }

    public Integer getUaccount() {
        return uaccount;
    }

    public void setUaccount(Integer uaccount) {
        this.uaccount = uaccount;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String unaem) {
        this.uname = unaem;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    @Override
    public String toString() {
        return "User{" +
                "uaccount=" + uaccount +
                ", upassword='" + upassword + '\'' +
                ", uname='" + uname + '\'' +
                ", usex='" + usex + '\'' +
                '}';
    }
}

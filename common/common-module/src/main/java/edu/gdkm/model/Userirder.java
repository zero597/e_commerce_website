package edu.gdkm.model;

import java.sql.Date;
import java.util.List;

/**
 * 商品订单类
 */
public class Userirder {
    private Integer gid;
    private List<User> uid;
    private String goodsname;
    private Integer number;
    private Integer price;
    private Date time; //购买时间

    public Userirder() {
    }

    public Userirder(Integer gid, List<User> uid, String goodsname, Integer number, Integer price, Date time) {
        this.gid = gid;
        this.uid = uid;
        this.goodsname = goodsname;
        this.number = number;
        this.price = price;
        this.time = time;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public List<User> getUid() {
        return uid;
    }

    public void setUid(List<User> uid) {
        this.uid = uid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Userirder{" +
                "gid=" + gid +
                ", uid=" + uid +
                ", goodsname='" + goodsname + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", time=" + time +
                '}';
    }
}

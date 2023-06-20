package edu.gdkm.model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * 商品订单类
 */
public class Userirder {
    private Integer id;
    private int uid;
    private String goodsname;
    private Integer number;
    private Integer price;
    private LocalDateTime time; //购买时间

    private SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Userirder() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}

package edu.gdkm.model;

import java.util.List;

/**
 * 购物车类
 */
public class Cart {
    private Integer id;
    private String goodsname;
    private Integer number;
    private double price;
    private List<Goods> goodid;
    private List<User> uid;

    public Cart() {
    }

    public Cart(Integer id, String goodsname, Integer number, double price, List<Goods> goodid, List<User> uid) {
        this.id = id;
        this.goodsname = goodsname;
        this.number = number;
        this.price = price;
        this.goodid = goodid;
        this.uid = uid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Goods> getGoodid() {
        return goodid;
    }

    public void setGoodid(List<Goods> goodid) {
        this.goodid = goodid;
    }

    public List<User> getUid() {
        return uid;
    }

    public void setUid(List<User> uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", goodsname='" + goodsname + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", goodid=" + goodid +
                ", uid=" + uid +
                '}';
    }
}

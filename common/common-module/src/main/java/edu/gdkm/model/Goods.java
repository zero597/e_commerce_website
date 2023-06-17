package edu.gdkm.model;

import sun.dc.pr.PRError;

/**
 * 商品详情类
 */
public class Goods {
    private Integer gid;
    private String gname;
    private String gremain; //商品图片
    private String gdetails;
    private Integer gprice;
    private Integer types;

    public Goods() {
    }

    public Goods(Integer gid, String gname, String gremain, String gdetails, Integer gprice, Integer types) {
        this.gid = gid;
        this.gname = gname;
        this.gremain = gremain;
        this.gdetails = gdetails;
        this.gprice = gprice;
        this.types = types;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGremain() {
        return gremain;
    }

    public void setGremain(String gremain) {
        this.gremain = gremain;
    }

    public String getGdetails() {
        return gdetails;
    }

    public void setGdetails(String gdetails) {
        this.gdetails = gdetails;
    }

    public Integer getGprice() {
        return gprice;
    }

    public void setGprice(Integer gprice) {
        this.gprice = gprice;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", gremain='" + gremain + '\'' +
                ", gdetails='" + gdetails + '\'' +
                ", gprice=" + gprice +
                ", types=" + types +
                '}';
    }
}

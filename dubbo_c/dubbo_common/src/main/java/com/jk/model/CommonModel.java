package com.jk.model;

import java.io.Serializable;
import java.util.Date;

public class CommonModel implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer commodityid;

    private String commodityname;

    private String commoditycount;

    private String commodityimg;

    private Integer commoditystatus;

    private Date commoditydate;

    private String commodityguige;

    private String commoditydesc;

    private String commoditytype;

    private String commodity;

    private Integer commoprice;

    public Integer getCommoprice() {
        return commoprice;
    }

    public void setCommoprice(Integer commoprice) {
        this.commoprice = commoprice;
    }

    public Integer getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(Integer commodityid) {
        this.commodityid = commodityid;
    }

    public String getCommodityname() {
        return commodityname;
    }

    public void setCommodityname(String commodityname) {
        this.commodityname = commodityname == null ? null : commodityname.trim();
    }

    public String getCommoditycount() {
        return commoditycount;
    }

    public void setCommoditycount(String commoditycount) {
        this.commoditycount = commoditycount == null ? null : commoditycount.trim();
    }

    public String getCommodityimg() {
        return commodityimg;
    }

    public void setCommodityimg(String commodityimg) {
        this.commodityimg = commodityimg == null ? null : commodityimg.trim();
    }

    public Integer getCommoditystatus() {
        return commoditystatus;
    }

    public void setCommoditystatus(Integer commoditystatus) {
        this.commoditystatus = commoditystatus;
    }

    public Date getCommoditydate() {
        return commoditydate;
    }

    public void setCommoditydate(Date commoditydate) {
        this.commoditydate = commoditydate;
    }

    public String getCommodityguige() {
        return commodityguige;
    }

    public void setCommodityguige(String commodityguige) {
        this.commodityguige = commodityguige == null ? null : commodityguige.trim();
    }

    public String getCommoditydesc() {
        return commoditydesc;
    }

    public void setCommoditydesc(String commoditydesc) {
        this.commoditydesc = commoditydesc == null ? null : commoditydesc.trim();
    }

    public String getCommoditytype() {
        return commoditytype;
    }

    public void setCommoditytype(String commoditytype) {
        this.commoditytype = commoditytype == null ? null : commoditytype.trim();
    }

    public String getCommodity() {
        return commodity;
    }

    public void setCommodity(String commodity) {
        this.commodity = commodity == null ? null : commodity.trim();
    }
}
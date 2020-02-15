package com.jk.model;

public class CommodityModel {
    /*这是商品到实体类*/
   /* T_commodity  商品表
    commodity_id       商品ID
    commodity_img      商品图片
    commodity_name    商品名称
    commodity_parameter  商品参数
    Commodity_price      商品单价
    Commodity_number    商品数量*/
   private Integer commodity_id;
   private String commodity_img;
   private String commodity_name;
   private String commodity_parameter;
   private Integer Commodity_price;
   private Integer Commodity_number;

    public Integer getCommodity_id() {
        return commodity_id;
    }

    public void setCommodity_id(Integer commodity_id) {
        this.commodity_id = commodity_id;
    }

    public String getCommodity_img() {
        return commodity_img;
    }

    public void setCommodity_img(String commodity_img) {
        this.commodity_img = commodity_img;
    }

    public String getCommodity_name() {
        return commodity_name;
    }

    public void setCommodity_name(String commodity_name) {
        this.commodity_name = commodity_name;
    }

    public String getCommodity_parameter() {
        return commodity_parameter;
    }

    public void setCommodity_parameter(String commodity_parameter) {
        this.commodity_parameter = commodity_parameter;
    }

    public Integer getCommodity_price() {
        return Commodity_price;
    }

    public void setCommodity_price(Integer commodity_price) {
        Commodity_price = commodity_price;
    }

    public Integer getCommodity_number() {
        return Commodity_number;
    }

    public void setCommodity_number(Integer commodity_number) {
        Commodity_number = commodity_number;
    }
}

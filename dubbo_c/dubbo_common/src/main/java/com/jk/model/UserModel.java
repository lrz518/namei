package com.jk.model;

import java.io.Serializable;

public class UserModel   implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer userid;

    private String useriphone;

    private String userpassword;

    private String username;

    private String userimg;

    private Integer member;

    private String address;

    private String jifen;

    private Integer addressjibie;

    private String yue;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public void setUseriphone(String useriphone) {
        this.useriphone = useriphone;
    }

    public void setMember(Integer member) {
        this.member = member;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUseriphone() {
        return useriphone;
    }

    public Integer getMember() {
        return member;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserimg() {
        return userimg;
    }

    public void setUserimg(String userimg) {
        this.userimg = userimg == null ? null : userimg.trim();
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getJifen() {
        return jifen;
    }

    public void setJifen(String jifen) {
        this.jifen = jifen == null ? null : jifen.trim();
    }

    public Integer getAddressjibie() {
        return addressjibie;
    }

    public void setAddressjibie(Integer addressjibie) {
        this.addressjibie = addressjibie;
    }

    public String getYue() {
        return yue;
    }

    public void setYue(String yue) {
        this.yue = yue == null ? null : yue.trim();
    }
}
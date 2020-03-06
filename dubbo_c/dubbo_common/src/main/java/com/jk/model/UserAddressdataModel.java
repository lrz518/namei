package com.jk.model;

import java.io.Serializable;

//用户的收货地址
public class UserAddressdataModel implements Serializable {

    /*T_UserAddressdata
    addressdataid;  //地址ID
    user_id    用户ID
    name     收货人名称
    City       收货地址城市
    Area      区/县
    Minarea   详细地址
    Phone     收货人手机号
    state     状态  0为默认地址 1为非默认地址     */

    private Integer user_id;
    private String name;
    private String city;
    private String area;
    private String minarea;
    private String phone;
    private Integer state;
    private Integer addressdataid;  //地址ID


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMinarea() {
        return minarea;
    }

    public void setMinarea(String minarea) {
        this.minarea = minarea;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getAddressdataid() {
        return addressdataid;
    }

    public void setAddressdataid(Integer addressdataid) {
        this.addressdataid = addressdataid;
    }
}

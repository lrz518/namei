package com.jk.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.model.CommodityModel;
import com.jk.model.UserAddressdataModel;
import com.jk.service.ShoppingCartService;
import com.jk.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("shoppingCart")
@ComponentScan(basePackages = {"com.jk.*"})
public class ShoppingCartController {

    @Reference
    private ShoppingCartService shoppingCartService;

    @Autowired
    private  RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private RedisUtil redis;

    //加载用户的收货地址
    @RequestMapping("/loadUserReceivingAddressInfo")
    @ResponseBody
    public List<UserAddressdataModel> loadUserReceivingAddressInfo(){
        //1.从Redis中获取用户信息

        //2.从MySQL中获取用户所有的信息

        //3.拿到用户ID从MySQL中获取用户的收货地址
        Integer userId = 1;
        List<UserAddressdataModel> addressdata = shoppingCartService.loadUserReceivingAddressList(userId);//传递参数：用户ID
        return addressdata;
    }


    //跳转到商品结算页面
    @RequestMapping("/loadSettlement")
    private String loadSettlement(){
        return "myOrder";
    }

    //商品存Redis
    @RequestMapping("/redisAddShopping")
    @ResponseBody
    private void redisAddShopping(){
        //获取用户信息

        //商品信息
        CommodityModel commodityModel = new CommodityModel();
        commodityModel.setCommodity_id(1);
        commodityModel.setCommodity_img("212");
        commodityModel.setCommodity_name("妮维雅洁面乳");
        commodityModel.setCommodity_parameter("洁面乳");
        commodityModel.setCommodity_price(88);
        commodityModel.setCommodity_number(1);
        String string = commodityModel.toString();
        //存Redis

    }
    /*加载用户购物车信息*/
    @RequestMapping("/loadUserShoppingCartInfo")
    @ResponseBody
    public List<CommodityModel> loadUserShoppingCartInfo() {
        //判断用户是否登录
        List<CommodityModel> loadUserShoppingCartInfo = new ArrayList<>();
        if (true) {//已登录
            //从Redis获取用户购物车信息

            CommodityModel commodityModel = new CommodityModel();
            commodityModel.setCommodity_id(1);
            commodityModel.setCommodity_img("https://1907lq.oss-cn-beijing.aliyuncs.com/img/shopping/u5122.png");
            commodityModel.setCommodity_name("妮维雅洁面乳");
            commodityModel.setCommodity_parameter("洁面乳");
            commodityModel.setCommodity_price(88);
            commodityModel.setCommodity_number(1);

            CommodityModel commodityModelTwo = new CommodityModel();
            commodityModelTwo.setCommodity_id(2);
            commodityModelTwo.setCommodity_img("https://1907lq.oss-cn-beijing.aliyuncs.com/img/shopping/u5127.png");
            commodityModelTwo.setCommodity_name("清扬洗发露");
            commodityModelTwo.setCommodity_parameter("洗发露");
            commodityModelTwo.setCommodity_price(23);
            commodityModelTwo.setCommodity_number(2);

            CommodityModel commodityModelThree = new CommodityModel();
            commodityModelThree.setCommodity_id(3);
            commodityModelThree.setCommodity_img("https://1907lq.oss-cn-beijing.aliyuncs.com/img/shopping/u5127.png");
            commodityModelThree.setCommodity_name("飘柔洗发露");
            commodityModelThree.setCommodity_parameter("洗发露");
            commodityModelThree.setCommodity_price(33);
            commodityModelThree.setCommodity_number(2);

            loadUserShoppingCartInfo.add(commodityModelTwo);
            loadUserShoppingCartInfo.add(commodityModel);
            loadUserShoppingCartInfo.add(commodityModelThree);

            return loadUserShoppingCartInfo;
        } else {//未登录
            //跳转到登录页面
            return loadUserShoppingCartInfo;
        }
    }

    //加载我的订单信息
    @RequestMapping("findMyuOrderTable")
    @ResponseBody
    public List<Map> findMyuOrderTable(Integer inputState,String startTime,String endTime){
        //1.从Redis中获取用户信息

        //2.从MySQL中获取用户所有的信息

        //3.拿到用户ID从MySQL中获取用户的收货地址
        Integer userId = 1;
        List<Map> myOderinfo = shoppingCartService.findMyuOrderTable(userId,inputState,startTime,endTime);
        return myOderinfo;

    }

    //取消订单
    @RequestMapping("deleteMyOrderById")
    @ResponseBody
    public void deleteMyOrderById(Integer orderNumber){
        shoppingCartService.deleteMyOrderById(orderNumber);
    }
}

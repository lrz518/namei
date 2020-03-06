package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.ShoppingCartMapper;
import com.jk.model.UserAddressdataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Service(interfaceClass = ShoppingCartService.class)
@Component
public class ShoppingCartServiceImpl implements ShoppingCartService{

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    //加载用户的收货地址
    @Override
    public List<UserAddressdataModel> loadUserReceivingAddressList(Integer userId) {
        List<UserAddressdataModel> userAddressdataModels = shoppingCartMapper.loadUserReceivingAddressList(userId);
        return userAddressdataModels;
    }

    @Override
    public List<Map> findMyuOrderTable(Integer userId,Integer inputState,String startTime,String endTime) {
        return shoppingCartMapper.findMyuOrderTable(userId,inputState,startTime,endTime);
    }

    @Override
    public void deleteMyOrderById(Integer orderNumber) {
        shoppingCartMapper.deleteMyOrderById(orderNumber);
    }
}

package com.jk.service;

import com.jk.model.UserAddressdataModel;

import java.util.List;
import java.util.Map;

public interface ShoppingCartService {

    List<UserAddressdataModel> loadUserReceivingAddressList(Integer userId);

    List<Map> findMyuOrderTable(Integer userId, Integer inputState, String startTime, String endTime);

    void deleteMyOrderById(Integer orderNumber);
}

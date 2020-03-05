package com.jk.service;

import com.jk.model.CommonModel;

import java.util.List;

public interface CommodityService {


    List<CommonModel> queryshangp(Integer id);

    List<CommonModel> queryFresh();

    List<CommonModel> queryVegetables();

    List<CommonModel> querygift();

    List<CommonModel> querySnacks();

    List<CommonModel> queryWine();

    List<CommonModel> querysuger();

    List<CommonModel> queryDrinks();
}

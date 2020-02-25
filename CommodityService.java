package com.jk.service;

import com.jk.model.CommonModel;

import java.util.List;

public interface CommodityService {
    /*查看特价商品*/
    List<CommonModel> querycommodityT();

    List<CommonModel> querydaily();

    List<CommonModel> queryPopular();

    List<CommonModel> queryThisweek();

    List<CommonModel> queryListweek();

    List<CommonModel> queryFresh();

    List<CommonModel> queryRecommend();

    List<CommonModel> queryVegetables();

    List<CommonModel> queryReVegetables();

    List<CommonModel> querybreakfast();

    List<CommonModel> queryRebreakfast();

    List<CommonModel> querysnacks();

    List<CommonModel> querychips();

    List<CommonModel> querywine();

    List<CommonModel> querydrinks();

    List<CommonModel> querygiftbox();

    List<CommonModel> queryolidaygift();

    List<CommonModel> queryRedaily();

    List<CommonModel> querysugar();

    List<CommonModel> querySoftsweets();

    List<CommonModel> queryWash();

    List<CommonModel> queryCooked();

    List<CommonModel> queryshangp(Integer id);
}

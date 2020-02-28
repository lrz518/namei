package com.jk.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.mapper.CommonModelMapper;
import com.jk.model.CommonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service(interfaceClass = CommodityService.class,timeout = 100000)
@Component
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommonModelMapper commonModelMapper;

    @Override
    public List<CommonModel> querycommodityT() {
        return commonModelMapper.querycommodityT();
    }

    @Override
    public List<CommonModel> querydaily() {
        return commonModelMapper.querydaily();
    }

    @Override
    public List<CommonModel> queryPopular() {
        return  commonModelMapper.queryPopular();
    }

    @Override
    public List<CommonModel> queryThisweek() {
        return commonModelMapper.queryThisweek();
    }

    @Override
    public List<CommonModel> queryListweek() {
        return commonModelMapper.queryListweek();
    }

    @Override
    public List<CommonModel> queryFresh() {
        return commonModelMapper.queryFresh();
    }

    @Override
    public List<CommonModel> queryRecommend() {
        return commonModelMapper.queryRecommend();
    }

    @Override
    public List<CommonModel> queryVegetables() {
        return commonModelMapper.queryVegetables();
    }

    @Override
    public List<CommonModel> queryReVegetables() {
        return  commonModelMapper.queryReVegetables();
    }

    @Override
    public List<CommonModel> querybreakfast() {
        return  commonModelMapper.querybreakfast();
    }

    @Override
    public List<CommonModel> queryRebreakfast() {
        return  commonModelMapper.queryRebreakfast();
    }

    @Override
    public List<CommonModel> querysnacks() {
        return commonModelMapper.querysnacks();
    }

    @Override
    public List<CommonModel> querychips() {
        return  commonModelMapper.querychips();
    }

    @Override
    public List<CommonModel> querywine() {
        return commonModelMapper.querywine();
    }

    @Override
    public List<CommonModel> querydrinks() {
        return commonModelMapper.querydrinks();
    }

    @Override
    public List<CommonModel> querygiftbox() {
        return commonModelMapper.querygiftbox();
    }

    @Override
    public List<CommonModel> queryolidaygift() {
        return commonModelMapper.queryolidaygift();
    }

    @Override
    public List<CommonModel> queryRedaily() {
        return commonModelMapper.queryRedaily();
    }

    @Override
    public List<CommonModel> querysugar() {
        return commonModelMapper.querysugar();
    }

    @Override
    public List<CommonModel> querySoftsweets() {
        return commonModelMapper.querySoftsweets();
    }

    @Override
    public List<CommonModel> queryWash() {
        return  commonModelMapper.queryWash();
    }

    @Override
    public List<CommonModel> queryCooked() {
        return commonModelMapper.queryCooked();
    }

    @Override
    public List<CommonModel> queryshangp(Integer id) {
        return commonModelMapper.queryshangp(id);
    }
}

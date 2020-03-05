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
    public List<CommonModel> queryshangp(Integer id) {
        return commonModelMapper.queryshangp(id);
    }

    @Override
    public List<CommonModel> queryFresh() {
        return commonModelMapper.queryFresh();
    }

    @Override
    public List<CommonModel> queryVegetables() {
        return commonModelMapper.queryVegetables();
    }

    @Override
    public List<CommonModel> querygift() {
        return commonModelMapper.querygift();
    }

    @Override
    public List<CommonModel> querySnacks() {
        return  commonModelMapper.querySnacks();
    }

    @Override
    public List<CommonModel> queryWine() {
        return commonModelMapper.queryWine();
    }

    @Override
    public List<CommonModel> querysuger() {
        return commonModelMapper.querysuger();
    }

    @Override
    public List<CommonModel> queryDrinks() {
        return  commonModelMapper.queryDrinks();
    }
}

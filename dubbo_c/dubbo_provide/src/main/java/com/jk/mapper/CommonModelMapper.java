package com.jk.mapper;

import com.jk.model.CommonModel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommonModelMapper {
    int deleteByPrimaryKey(Integer commodityid);

    int insert(CommonModel record);

    int insertSelective(CommonModel record);

    CommonModel selectByPrimaryKey(Integer commodityid);

    int updateByPrimaryKeySelective(CommonModel record);

    int updateByPrimaryKey(CommonModel record);


    @Select("select * from commodity where commodityid = #{id}  ")
    List<CommonModel> queryshangp(Integer id);
    /*查看水果*/
    @Select("select * from commodity where commoditytype = 3")
    List<CommonModel> queryFresh();
    /*查看蔬菜类*/
    @Select("select * from commodity where commoditytype =1")
    List<CommonModel> queryVegetables();
    /*查看礼品*/
    @Select("select * from commodity where commoditytype =9")
    List<CommonModel> querygift();
    /*查看休闲零食*/
    @Select("select * from commodity where commoditytype =6")
    List<CommonModel> querySnacks();
    /*查看酒水*/
    @Select("select * from commodity where commoditytype =7")
    List<CommonModel> queryWine();
    /*查看糖果*/
    @Select("select * from commodity where commoditytype =11")
    List<CommonModel> querysuger();
    /*查看饮料*/
    @Select("select * from commodity where commoditytype = 8")
    List<CommonModel> queryDrinks();
}
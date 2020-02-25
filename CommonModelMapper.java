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
    /*查看特价商品*/
    @Select("select * from commodity where commoprice <= 35 and commoditytype = 1 order by commoprice")
    List<CommonModel> querycommodityT();
    /*查看生活用品*/
    @Select("select * from commodity where commoditytype =2 order by commoprice ")
    List<CommonModel> querydaily();
    /*查看热门商品*/
    @Select("select * from commodity order by  commoditycount  desc ")
    List<CommonModel> queryPopular();
    /*查看本周商品*/
    @Select("SELECT * FROM commodity WHERE commoditytype = 1 and  YEARWEEK(DATE_FORMAT(commoditydate,'%Y-%m-%d')) = YEARWEEK(NOW())")
    List<CommonModel> queryThisweek();
    @Select("SELECT * FROM commodity WHERE commoditytype = 1 and YEARWEEK(DATE_FORMAT(commoditydate,'%Y-%m-%d')) = YEARWEEK(NOW())-1")
    List<CommonModel> queryListweek();
    @Select("SELECT * FROM commodity WHERE commoditytype = 3 and  YEARWEEK(DATE_FORMAT(commoditydate,'%Y-%m-%d')) = YEARWEEK(NOW()) ")
    List<CommonModel> queryFresh();
    @Select("SELECT * FROM commodity  where commoditytype = 3 ORDER BY RAND() LIMIT 6 ")
    List<CommonModel> queryRecommend();
    @Select("SELECT * FROM commodity WHERE commoditytype = 1 and  YEARWEEK(DATE_FORMAT(commoditydate,'%Y-%m-%d')) = YEARWEEK(NOW()) ")
    List<CommonModel> queryVegetables();
    @Select("SELECT * FROM commodity  where commoditytype = 1 ORDER BY RAND() LIMIT 6")
    List<CommonModel> queryReVegetables();
    @Select("select * from commodity where commoditytype = 4 ")
    List<CommonModel> querybreakfast();
    @Select("select * from commodity where commoditytype = 4 ORDER BY RAND() LIMIT 6 ")
    List<CommonModel> queryRebreakfast();
    @Select("select * from commodity where commoditytype = 5  ")
    List<CommonModel> querysnacks();
    @Select("select * from commodity where commoditytype = 6  ")
    List<CommonModel> querychips();
    @Select("select * from commodity where commoditytype = 7  ")
    List<CommonModel> querywine();
    @Select("select * from commodity where commoditytype = 8  ")
    List<CommonModel> querydrinks();
    @Select("select * from commodity where commoditytype = 9  ")
    List<CommonModel> querygiftbox();
    @Select("select * from commodity where commoditytype = 10  ")
    List<CommonModel> queryolidaygift();
    @Select("SELECT * FROM commodity  where commoditytype = 2 ORDER BY RAND() LIMIT 6")
    List<CommonModel> queryRedaily();
    @Select("select * from commodity where commoditytype = 11  ")
    List<CommonModel> querysugar();
    @Select("select * from commodity where commoditytype = 12  ")
    List<CommonModel> querySoftsweets();
    @Select("select * from commodity where commoditytype = 13  ")
    List<CommonModel> queryWash();
    @Select("select * from commodity where commoditytype = 14  ")
    List<CommonModel> queryCooked();

    @Select("select * from commodity where commodityid = #{id}  ")
    List<CommonModel> queryshangp(Integer id);
}
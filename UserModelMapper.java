package com.jk.mapper;

import com.jk.model.UserModel;
import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModelMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(UserModel record);

    int insertSelective(UserModel record);

    UserModel selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserModel record);

    int updateByPrimaryKey(UserModel record);
    @Select("select * from  t_user where  useriphone = #{value}")
    UserModel findUserPhone(String useriphone);

   


    void register(UserModel userModel);
}
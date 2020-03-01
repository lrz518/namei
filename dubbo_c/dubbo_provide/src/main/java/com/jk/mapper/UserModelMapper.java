package com.jk.mapper;

import com.jk.model.UserModel;
import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModelMapper {



    @Select("select * from  t_user where  useriphone = #{value}")
    UserModel findUserPhone(String useriphone);

    void register(UserModel userModel);
}
package com.jk.mapper;

import com.jk.model.UserModel;
import org.springframework.stereotype.Repository;

@Repository
public interface UserModelMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(UserModel record);

    int insertSelective(UserModel record);

    UserModel selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(UserModel record);

    int updateByPrimaryKey(UserModel record);
}
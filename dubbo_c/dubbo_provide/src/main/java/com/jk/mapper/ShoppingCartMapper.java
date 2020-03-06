package com.jk.mapper;

import com.jk.model.UserAddressdataModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ShoppingCartMapper {
    @Select("SELECT * FROM t_useraddressdata WHERE user_id = #{value} and state = 0" )
    List<UserAddressdataModel> loadUserReceivingAddressList(Integer userId);

    List<Map> findMyuOrderTable(@Param("userId") Integer userId, @Param("inputState")Integer inputState, @Param("startTime") String startTime, @Param("endTime") String endTime);

    @Delete("DELETE FROM t_myOrder  where orderNumber = #{value} ")
    void deleteMyOrderById(Integer orderNumber);
}

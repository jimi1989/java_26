package com.kaishengit.erp.mapper;

import com.kaishengit.erp.entity.OrderEmployee;
import com.kaishengit.erp.entity.OrderEmployeeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderEmployeeMapper {
    long countByExample(OrderEmployeeExample example);

    int deleteByExample(OrderEmployeeExample example);

    int insert(OrderEmployee record);

    int insertSelective(OrderEmployee record);

    List<OrderEmployee> selectByExample(OrderEmployeeExample example);

    int updateByExampleSelective(@Param("record") OrderEmployee record, @Param("example") OrderEmployeeExample example);

    int updateByExample(@Param("record") OrderEmployee record, @Param("example") OrderEmployeeExample example);
}
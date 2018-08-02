package com.kaishengit.erp.mapper;

import com.kaishengit.erp.entity.OrderParts;
import com.kaishengit.erp.entity.OrderPartsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderPartsMapper {
    long countByExample(OrderPartsExample example);

    int deleteByExample(OrderPartsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderParts record);

    int insertSelective(OrderParts record);

    List<OrderParts> selectByExample(OrderPartsExample example);

    OrderParts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderParts record, @Param("example") OrderPartsExample example);

    int updateByExample(@Param("record") OrderParts record, @Param("example") OrderPartsExample example);

    int updateByPrimaryKeySelective(OrderParts record);

    int updateByPrimaryKey(OrderParts record);
}
package com.kaishengit.erp.mapper;

import com.kaishengit.erp.entity.CountTimeout;
import com.kaishengit.erp.entity.CountTimeoutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CountTimeoutMapper {
    long countByExample(CountTimeoutExample example);

    int deleteByExample(CountTimeoutExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CountTimeout record);

    int insertSelective(CountTimeout record);

    List<CountTimeout> selectByExample(CountTimeoutExample example);

    CountTimeout selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CountTimeout record, @Param("example") CountTimeoutExample example);

    int updateByExample(@Param("record") CountTimeout record, @Param("example") CountTimeoutExample example);

    int updateByPrimaryKeySelective(CountTimeout record);

    int updateByPrimaryKey(CountTimeout record);
}
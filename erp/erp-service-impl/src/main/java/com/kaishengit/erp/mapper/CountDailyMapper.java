package com.kaishengit.erp.mapper;

import com.kaishengit.erp.entity.CountDaily;
import com.kaishengit.erp.entity.CountDailyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CountDailyMapper {
    long countByExample(CountDailyExample example);

    int deleteByExample(CountDailyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CountDaily record);

    int insertSelective(CountDaily record);

    List<CountDaily> selectByExample(CountDailyExample example);

    CountDaily selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CountDaily record, @Param("example") CountDailyExample example);

    int updateByExample(@Param("record") CountDaily record, @Param("example") CountDailyExample example);

    int updateByPrimaryKeySelective(CountDaily record);

    int updateByPrimaryKey(CountDaily record);
}
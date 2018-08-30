package com.kaishengit.tms.mapper;

import com.kaishengit.tms.entity.StoreLoginLog;
import com.kaishengit.tms.entity.StoreLoginLogExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreLoginLogMapper {
    long countByExample(StoreLoginLogExample example);

    int deleteByExample(StoreLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StoreLoginLog record);

    int insertSelective(StoreLoginLog record);

    List<StoreLoginLog> selectByExample(StoreLoginLogExample example);

    StoreLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StoreLoginLog record, @Param("example") StoreLoginLogExample example);

    int updateByExample(@Param("record") StoreLoginLog record, @Param("example") StoreLoginLogExample example);

    int updateByPrimaryKeySelective(StoreLoginLog record);

    int updateByPrimaryKey(StoreLoginLog record);
}
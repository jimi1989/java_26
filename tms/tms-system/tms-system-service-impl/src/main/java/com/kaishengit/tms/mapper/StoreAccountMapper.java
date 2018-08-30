package com.kaishengit.tms.mapper;

import com.kaishengit.tms.entity.StoreAccount;
import com.kaishengit.tms.entity.StoreAccountExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreAccountMapper {
    long countByExample(StoreAccountExample example);

    int deleteByExample(StoreAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StoreAccount record);

    int insertSelective(StoreAccount record);

    List<StoreAccount> selectByExample(StoreAccountExample example);

    StoreAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StoreAccount record, @Param("example") StoreAccountExample example);

    int updateByExample(@Param("record") StoreAccount record, @Param("example") StoreAccountExample example);

    int updateByPrimaryKeySelective(StoreAccount record);

    int updateByPrimaryKey(StoreAccount record);
}
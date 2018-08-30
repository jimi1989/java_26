package com.kaishengit.tms.mapper;

import com.kaishengit.tms.entity.AccountLoginLog;
import com.kaishengit.tms.entity.AccountLoginLogExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountLoginLogMapper {
    long countByExample(AccountLoginLogExample example);

    int deleteByExample(AccountLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AccountLoginLog record);

    int insertSelective(AccountLoginLog record);

    List<AccountLoginLog> selectByExample(AccountLoginLogExample example);

    AccountLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AccountLoginLog record, @Param("example") AccountLoginLogExample example);

    int updateByExample(@Param("record") AccountLoginLog record, @Param("example") AccountLoginLogExample example);

    int updateByPrimaryKeySelective(AccountLoginLog record);

    int updateByPrimaryKey(AccountLoginLog record);
}
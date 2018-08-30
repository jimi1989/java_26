package com.kaishengit.tms.mapper;

import com.kaishengit.tms.entity.AccountRolesExample;
import com.kaishengit.tms.entity.AccountRolesKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AccountRolesMapper {
    long countByExample(AccountRolesExample example);

    int deleteByExample(AccountRolesExample example);

    int deleteByPrimaryKey(AccountRolesKey key);

    int insert(AccountRolesKey record);

    int insertSelective(AccountRolesKey record);

    List<AccountRolesKey> selectByExample(AccountRolesExample example);

    int updateByExampleSelective(@Param("record") AccountRolesKey record, @Param("example") AccountRolesExample example);

    int updateByExample(@Param("record") AccountRolesKey record, @Param("example") AccountRolesExample example);
}
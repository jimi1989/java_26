package com.kaishengit.erp.mapper;

import com.kaishengit.erp.entity.PartsStream;
import com.kaishengit.erp.entity.PartsStreamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PartsStreamMapper {
    long countByExample(PartsStreamExample example);

    int deleteByExample(PartsStreamExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PartsStream record);

    int insertSelective(PartsStream record);

    List<PartsStream> selectByExample(PartsStreamExample example);

    PartsStream selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PartsStream record, @Param("example") PartsStreamExample example);

    int updateByExample(@Param("record") PartsStream record, @Param("example") PartsStreamExample example);

    int updateByPrimaryKeySelective(PartsStream record);

    int updateByPrimaryKey(PartsStream record);
}
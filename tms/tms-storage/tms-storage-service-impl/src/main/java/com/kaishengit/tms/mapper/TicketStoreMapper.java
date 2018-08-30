package com.kaishengit.tms.mapper;

import com.kaishengit.tms.entity.TicketStore;
import com.kaishengit.tms.entity.TicketStoreExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TicketStoreMapper {
    long countByExample(TicketStoreExample example);

    int deleteByExample(TicketStoreExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TicketStore record);

    int insertSelective(TicketStore record);

    List<TicketStore> selectByExample(TicketStoreExample example);

    TicketStore selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TicketStore record, @Param("example") TicketStoreExample example);

    int updateByExample(@Param("record") TicketStore record, @Param("example") TicketStoreExample example);

    int updateByPrimaryKeySelective(TicketStore record);

    int updateByPrimaryKey(TicketStore record);
}
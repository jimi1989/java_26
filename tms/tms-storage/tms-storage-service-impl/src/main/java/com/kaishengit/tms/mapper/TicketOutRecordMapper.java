package com.kaishengit.tms.mapper;

import com.kaishengit.tms.entity.TicketOutRecord;
import com.kaishengit.tms.entity.TicketOutRecordExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TicketOutRecordMapper {
    long countByExample(TicketOutRecordExample example);

    int deleteByExample(TicketOutRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TicketOutRecord record);

    int insertSelective(TicketOutRecord record);

    List<TicketOutRecord> selectByExample(TicketOutRecordExample example);

    TicketOutRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TicketOutRecord record, @Param("example") TicketOutRecordExample example);

    int updateByExample(@Param("record") TicketOutRecord record, @Param("example") TicketOutRecordExample example);

    int updateByPrimaryKeySelective(TicketOutRecord record);

    int updateByPrimaryKey(TicketOutRecord record);
}
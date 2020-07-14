package com.atom.alumni.mapper;

import com.atom.alumni.domain.Alumni;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AlumniMapper {
    int deleteByPrimaryKey(String alumniNumber);

    int insert(Alumni record);

    int insertSelective(Alumni record);

    Alumni selectByPrimaryKey(String alumniNumber);

    int updateByPrimaryKeySelective(Alumni record);

    int updateByPrimaryKey(Alumni record);

    List<Alumni> findByName(@Param("name") String name);

    List<Alumni> getAllAlumni();
}
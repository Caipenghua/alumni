package com.atom.alumni.mapper;

import com.atom.alumni.domain.Alumni;
import com.atom.alumni.domain.Class;

import java.util.List;

public interface ClassMapper {
    int deleteByPrimaryKey(Integer classId);

    int insert(Class record);

    int insertSelective(Class record);

    Class selectByPrimaryKey(Integer classId);

    int updateByPrimaryKeySelective(Class record);

    int updateByPrimaryKey(Class record);

    List<Class> getAllClass();
}
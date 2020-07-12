package com.atom.alumni.mapper;

import com.atom.alumni.domain.Mycomment;

public interface MycommentMapper {
    int deleteByPrimaryKey(Integer mycommentId);

    int insert(Mycomment record);

    int insertSelective(Mycomment record);

    Mycomment selectByPrimaryKey(Integer mycommentId);

    int updateByPrimaryKeySelective(Mycomment record);

    int updateByPrimaryKey(Mycomment record);
}
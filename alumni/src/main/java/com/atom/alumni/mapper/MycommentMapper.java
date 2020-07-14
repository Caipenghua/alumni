package com.atom.alumni.mapper;

import com.atom.alumni.domain.Mycomment;

import java.util.List;

public interface MycommentMapper {
    int deleteByPrimaryKey(Integer mycommentId);

    int insert(Mycomment record);

    int insertSelective(Mycomment record);

    Mycomment selectByPrimaryKey(Integer mycommentId);

    int updateByPrimaryKeySelective(Mycomment record);

    int updateByPrimaryKey(Mycomment record);

    List<Integer> selectIdFromPostId(Integer postId);

    List<Mycomment> selectByPostId(Integer id);
}
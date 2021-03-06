package com.atom.alumni.mapper;

import com.atom.alumni.domain.Post;

import java.util.List;

public interface PostMapper {
    int deleteByPrimaryKey(Integer postId);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer postId);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);

    List<Post> selectByAlumniNumber(Integer alumniNumber);

    List<Post> getPostList();
}
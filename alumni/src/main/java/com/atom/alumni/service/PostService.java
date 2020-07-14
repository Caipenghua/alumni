package com.atom.alumni.service;

import com.atom.alumni.domain.Mycomment;
import com.atom.alumni.mapper.MycommentMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.atom.alumni.domain.Post;
import com.atom.alumni.mapper.PostMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostService{

    @Resource
    private PostMapper postMapper;
    @Resource
    private MycommentMapper mycommentMapper;

    public List<Post> getPostList(){
        return postMapper.getAllPost();
    }

    public int insertPost(Post post){
        return postMapper.insert(post);
    }

    public int deletePost(Integer id){
        List<Integer> list=mycommentMapper.selectIdFromPostId(id);
        for(int i:list){
            mycommentMapper.deleteByPrimaryKey(i);
        }
        return postMapper.deleteByPrimaryKey(id);
    }


    public int insertCommentByPostId(Integer id, Mycomment mycomment){
        mycomment.setMycommentParent(-1);//首评论
        mycomment.setMycommentPost(id);
        return mycommentMapper.insertSelective(mycomment);
    }

    public int insertCommentByCommentId(Integer id, Mycomment mycomment){
        Mycomment mycommentParent = mycommentMapper.selectByPrimaryKey(id);
        Integer postId = mycommentParent.getMycommentPost();//获得父亲评论的 postId
        mycomment.setMycommentPost(postId);
        mycomment.setMycommentParent(id);
        return mycommentMapper.insertSelective(mycomment);

    }

    public Post selectPostAndComment(Integer id){
        return postMapper.selectByPrimaryKey(id);
    }

    public int deleteMycomment(Integer id){
        return mycommentMapper.deleteByPrimaryKey(id);
    }

    public int deleteByPrimaryKey(Integer postId) {
        return postMapper.deleteByPrimaryKey(postId);
    }


    public int insert(Post record) {
        return postMapper.insert(record);
    }


    public int insertSelective(Post record) {
        return postMapper.insertSelective(record);
    }


    public Post selectByPrimaryKey(Integer postId) {
        return postMapper.selectByPrimaryKey(postId);
    }


    public int updateByPrimaryKeySelective(Post record) {
        return postMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(Post record) {
        return postMapper.updateByPrimaryKey(record);
    }

}

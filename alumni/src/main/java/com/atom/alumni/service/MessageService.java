package com.atom.alumni.service;

import com.atom.alumni.domain.Mycomment;
import com.atom.alumni.domain.Post;
import com.atom.alumni.mapper.MycommentMapper;
import com.atom.alumni.mapper.PostMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageService {
    @Resource
    private PostMapper postMapper;
    @Resource
    private MycommentMapper mycommentMapper;

    public List<Post> getPostList(){
        return postMapper.getPostList();
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

    public List<Post> getPostListByAlumniId(Integer id){
        List<Post> list = postMapper.selectByAlumniNumber(id);
        return list;

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

    public Map<Post,List<Mycomment>> selectPostAndComment(Integer id){
        Map<Post,List<Mycomment>> map = new HashMap<>();
        map.put(postMapper.selectByPrimaryKey(id),mycommentMapper.selectByPostId(id));
        return map;
    }

    public int deleteMycomment(Integer id){
        return mycommentMapper.deleteByPrimaryKey(id);
    }

}

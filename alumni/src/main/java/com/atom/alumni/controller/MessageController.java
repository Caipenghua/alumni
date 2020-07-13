package com.atom.alumni.controller;

import com.atom.alumni.domain.Mycomment;
import com.atom.alumni.domain.Post;
import com.atom.alumni.service.MessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/post/list")
    public List<Post> getPostList(){
        return  messageService.getPostList();
    }

    @PostMapping("/post")
    public String insertPost(@RequestBody Post post){
        messageService.insertPost(post);
        return "save successfully";
    }

    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable Integer id){
        messageService.deletePost(id);
        return "delete successfully";
    }

    @GetMapping("/post/comment/{id}")
    public Map<Post, List<Mycomment>> getPostAndCommentByPostId(@PathVariable Integer id){
        return messageService.selectPostAndComment(id);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteMycommentById(@PathVariable Integer id){
        return messageService.deleteMycomment(id);
    }

    /*
    根据学号获得发帖记录
     */
    @GetMapping("/post/alumni/{id}")
    public List<Post> getPostListByAlumniId(@PathVariable Integer id){
        return messageService.getPostListByAlumniId(id);
    }

    /*
    对帖子进行回复
    id: post_id
     */
    @PostMapping("/comment/post/{id}")
    public String commentPost(@PathVariable Integer id,@RequestBody Mycomment mycomment){
        int result = messageService.insertCommentByPostId(id,mycomment);
        if(result!=0) {
            return "success";
        } else {
            return "fail";
        }
    }

    /*
    对回复进行回复
    id: mycomment_id
     */
    @PostMapping("/comment/comment/{id}")
    public String commentComment(@PathVariable Integer id,@RequestBody Mycomment mycomment){
        int result = messageService.insertCommentByCommentId(id,mycomment);
        if(result!=0) {
            return "success";
        } else {
            return "fail";
        }
    }
}

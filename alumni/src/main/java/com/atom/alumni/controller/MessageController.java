package com.atom.alumni.controller;

import com.atom.alumni.domain.Mycomment;

import com.atom.alumni.domain.Post;
import com.atom.alumni.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MessageController {

    @Autowired
    private PostService messageService;

    @RequestMapping(value = "/post/list")
    public List<Post> getPostList(){
        return  messageService.getPostList();
    }

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    @ResponseBody
    public String insertPost(@RequestBody Post post){
        //System.out.println(json);
        messageService.insertPost(post);
        return "save successfully";
    }

    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable Integer id){
        messageService.deletePost(id);
        return "delete successfully";
    }

    @RequestMapping(value ="/post/comment/{id}")
    public Post getPostAndCommentByPostId(@PathVariable Integer id){
        return messageService.selectPostAndComment(id);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteMycommentById(@PathVariable Integer id){
        return messageService.deleteMycomment(id);
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

package com.atom.alumni.domain;

import java.util.Date;

public class Post {
    /**
    * 帖子编号
    */
    private Integer postId;

    /**
    * 题目
    */
    private String postTitle;

    /**
    * 关键词
    */
    private String postKeyWord;

    /**
    * 内容
    */
    private String postContent;

    /**
    * 发表时间
    */
    private Date postPublishTime;

    /**
    * 发表人
    */
    private String postPublisher;

    /**
    * 是否删除
    */
    private String postDelete;

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostKeyWord() {
        return postKeyWord;
    }

    public void setPostKeyWord(String postKeyWord) {
        this.postKeyWord = postKeyWord;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public Date getPostPublishTime() {
        return postPublishTime;
    }

    public void setPostPublishTime(Date postPublishTime) {
        this.postPublishTime = postPublishTime;
    }

    public String getPostPublisher() {
        return postPublisher;
    }

    public void setPostPublisher(String postPublisher) {
        this.postPublisher = postPublisher;
    }

    public String getPostDelete() {
        return postDelete;
    }

    public void setPostDelete(String postDelete) {
        this.postDelete = postDelete;
    }
    
}
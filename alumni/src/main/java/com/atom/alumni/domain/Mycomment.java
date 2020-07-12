package com.atom.alumni.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * mycomment
 * @author 
 */
@Data
public class Mycomment implements Serializable {
    /**
     * 评论编号
     */
    private Integer mycommentId;

    /**
     * 评论内容
     */
    private String mycommentContent;

    /**
     * 评论时间
     */
    private Date mycommentPublishTime;

    /**
     * 在哪条帖子下的评论
     */
    private Integer mycommentPost;

    /**
     * 哪条评论的评论,如果是-1代表首评论
     */
    private Integer mycommentParent;

    /**
     * 发表人
     */
    private String mycommentPublisher;

    /**
     * 是否删除
     */
    private String mycommentDelete;

    public Integer getMycommentId() {
        return mycommentId;
    }

    public void setMycommentId(Integer mycommentId) {
        this.mycommentId = mycommentId;
    }

    public String getMycommentContent() {
        return mycommentContent;
    }

    public void setMycommentContent(String mycommentContent) {
        this.mycommentContent = mycommentContent;
    }

    public Date getMycommentPublishTime() {
        return mycommentPublishTime;
    }

    public void setMycommentPublishTime(Date mycommentPublishTime) {
        this.mycommentPublishTime = mycommentPublishTime;
    }

    public Integer getMycommentPost() {
        return mycommentPost;
    }

    public void setMycommentPost(Integer mycommentPost) {
        this.mycommentPost = mycommentPost;
    }

    public Integer getMycommentParent() {
        return mycommentParent;
    }

    public void setMycommentParent(Integer mycommentParent) {
        this.mycommentParent = mycommentParent;
    }

    public String getMycommentPublisher() {
        return mycommentPublisher;
    }

    public void setMycommentPublisher(String mycommentPublisher) {
        this.mycommentPublisher = mycommentPublisher;
    }

    public String getMycommentDelete() {
        return mycommentDelete;
    }

    public void setMycommentDelete(String mycommentDelete) {
        this.mycommentDelete = mycommentDelete;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    private static final long serialVersionUID = 1L;
}
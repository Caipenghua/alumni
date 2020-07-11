package com.atom.alumni.domain;

import java.util.Date;
import lombok.Data;

@Data
public class Class {
    /**
    * 班级编号
    */
    private Integer classId;

    /**
    * 年级
    */
    private String classGrade;

    /**
    * 班
    */
    private String classClass;

    /**
    * 专业
    */
    private String classMajor;

    /**
    * 创建人学号
    */
    private String classCreator;

    /**
    * 班级人数
    */
    private Integer classNumberOfMember;

    /**
    * 班级介绍
    */
    private String classIntroduction;

    /**
    * 创建时间
    */
    private Date classCreateTime;

    public Integer getClassId() {
        return classId;
    }

    public String getClassGrade() {
        return classGrade;
    }

    public String getClassClass() {
        return classClass;
    }

    public String getClassMajor() {
        return classMajor;
    }

    public String getClassCreator() {
        return classCreator;
    }

    public Integer getClassNumberOfMember() {
        return classNumberOfMember;
    }

    public String getClassIntroduction() {
        return classIntroduction;
    }

    public Date getClassCreateTime() {
        return classCreateTime;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public void setClassGrade(String classGrade) {
        this.classGrade = classGrade;
    }

    public void setClassClass(String classClass) {
        this.classClass = classClass;
    }

    public void setClassMajor(String classMajor) {
        this.classMajor = classMajor;
    }

    public void setClassCreator(String classCreator) {
        this.classCreator = classCreator;
    }

    public void setClassNumberOfMember(Integer classNumberOfMember) {
        this.classNumberOfMember = classNumberOfMember;
    }

    public void setClassIntroduction(String classIntroduction) {
        this.classIntroduction = classIntroduction;
    }

    public void setClassCreateTime(Date classCreateTime) {
        this.classCreateTime = classCreateTime;
    }
}
package com.atom.alumni.controller;

import com.atom.alumni.service.ClassService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.atom.alumni.domain.Class;

import java.util.List;


@RestController
public class ClassController {

    @Autowired
    private ClassService classesService;
    @RequestMapping(value = "/insertClass",method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody Class classes){
        //System.out.println(json);
        classesService.insert(classes);
        return "save successfully";
    }

    @RequestMapping(value = "/updateClass",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody Class classes){
        System.out.println(classes.getClassClass());
        classesService.updateByPrimaryKey(classes);
        return "update successfully";
    }

    @RequestMapping(value = "/getAllClass")
    public List<Class> getAllClass()
    {
        System.out.println("接受到获取数据请求！");
        return classesService.getAllClass();
    }
    @RequestMapping(value = "/getClassById/{id}")
    public Class getClassById(@PathVariable Integer id)
    {
        System.out.println("接受到获取数据请求！");
        return classesService.selectByPrimaryKey(id);
    }
    @RequestMapping(value = "/deleteClassById/{id}",method = RequestMethod.DELETE)
    public int deleteClassById(@PathVariable Integer id)
    {
        System.out.println("接受到获取数据请求！");
        return classesService.deleteByPrimaryKey(id);
    }
}
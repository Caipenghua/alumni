package com.atom.alumni.controller;

import com.atom.alumni.service.AlumniService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.atom.alumni.domain.Alumni;

import java.util.List;


@RestController
public class AlumniController {

    @Autowired
    private AlumniService alumniService;
    @RequestMapping(value = "/insertAlumni",method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody Alumni alumni){
        //System.out.println(json);
        alumniService.insert(alumni);
        return "save successfully";
    }

    @RequestMapping(value = "/updateAlumni",method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody Alumni alumni){
        System.out.println(alumni.getAlumniName());
        alumniService.updateByPrimaryKey(alumni);
        return "update successfully";
    }

    @RequestMapping(value = "/getAllAlumni")
    public List<Alumni> getAllAlumni()
    {
        System.out.println("接受到获取数据请求！");
        return alumniService.getAllAlumni();
    }
    @RequestMapping(value = "/getAlumniById/{id}")
    public Alumni getAlumniById(@PathVariable String id)
    {
        System.out.println("接受到获取数据请求！");
        return alumniService.selectByPrimaryKey(id);
    }
    @RequestMapping(value = "/deleteAlumniById/{id}",method = RequestMethod.DELETE)
    public int deleteAlumniById(@PathVariable String id)
    {
        System.out.println("接受到获取数据请求！");
        return alumniService.deleteByPrimaryKey(id);
    }
}
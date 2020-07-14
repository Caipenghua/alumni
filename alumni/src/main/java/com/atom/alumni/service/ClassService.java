package com.atom.alumni.service;

import com.atom.alumni.domain.Alumni;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.atom.alumni.mapper.ClassMapper;
import com.atom.alumni.domain.Class;

import java.util.List;

@Service
public class ClassService{

    @Resource
    private ClassMapper classMapper;

    
    public int deleteByPrimaryKey(Integer classId) {
        return classMapper.deleteByPrimaryKey(classId);
    }

    
    public int insert(Class record) {
        return classMapper.insert(record);
    }

    
    public int insertSelective(Class record) {
        return classMapper.insertSelective(record);
    }

    
    public Class selectByPrimaryKey(Integer classId) {
        return classMapper.selectByPrimaryKey(classId);
    }

    
    public int updateByPrimaryKeySelective(Class record) {
        return classMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Class record) {
        return classMapper.updateByPrimaryKey(record);
    }
    public List<Class> getAllClass()
    {
        return classMapper.getAllClass();
    }
}

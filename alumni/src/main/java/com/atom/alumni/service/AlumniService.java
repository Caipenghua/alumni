package com.atom.alumni.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.atom.alumni.mapper.AlumniMapper;
import com.atom.alumni.domain.Alumni;

import java.util.List;

@Service
public class AlumniService{

    @Resource
    private AlumniMapper alumniMapper;

    
    public int deleteByPrimaryKey(String alumniNumber) {
        return alumniMapper.deleteByPrimaryKey(alumniNumber);
    }

    
    public int insert(Alumni record) {
        return alumniMapper.insert(record);
    }

    
    public int insertSelective(Alumni record) {
        return alumniMapper.insertSelective(record);
    }

    
    public Alumni selectByPrimaryKey(String alumniNumber) {
        return alumniMapper.selectByPrimaryKey(alumniNumber);
    }

    
    public int updateByPrimaryKeySelective(Alumni record) {
        return alumniMapper.updateByPrimaryKeySelective(record);
    }

    
    public int updateByPrimaryKey(Alumni record) {
        return alumniMapper.updateByPrimaryKey(record);
    }
    public List<Alumni> getAllAlumni()
    {
        return alumniMapper.getAllAlumni();
    }

}

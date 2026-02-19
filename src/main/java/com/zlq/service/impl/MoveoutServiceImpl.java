package com.zlq.service.impl;

import com.zlq.mapper.MoveoutMapper;
import com.zlq.pojo.Moveout;
import com.zlq.service.MoveoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MoveoutServiceImpl implements MoveoutService {

    @Autowired
    private MoveoutMapper moveoutMapper;
    @Override
    public List<Moveout> list() {
        return moveoutMapper.list();
    }

    @Override
    public List<Moveout> search(String key, String value) {
        if(value.equals(""))
            return this.list();
        switch (key){
            case "studentName":
                return this.moveoutMapper.searchByStudentName(value);
            case "dormitoryName":
                return this.moveoutMapper.searchByDormitoryName(value);
            default:
                return this.list();
        }
    }
}

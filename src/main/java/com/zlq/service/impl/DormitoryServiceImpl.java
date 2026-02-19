package com.zlq.service.impl;

import com.zlq.mapper.DormitoryMapper;
import com.zlq.mapper.StudentMapper;
import com.zlq.pojo.Dormitory;
import com.zlq.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class DormitoryServiceImpl implements DormitoryService {


    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public List<Dormitory> listAll() {
        return this.dormitoryMapper.listAll();
    }

    @Override
    public List<Dormitory> listAvailable() {
        return this.dormitoryMapper.availableList();
    }

    @Override
    public Integer findAvailableDormitoryId() {
        return this.dormitoryMapper.availableDormitoryId();
    }

    @Override
    public List<Integer> listStudentIdByDormitoryId(Integer dormitoryId) {
        return this.dormitoryMapper.listStudentIdByDormitoryId(dormitoryId);

    }

    @Override
    public void transferStudent(Integer studentId, Integer availableDormitoryId) {
        this.dormitoryMapper.transferStudent(studentId, availableDormitoryId);
    }

    @Override
    public void deleteById(Integer dormitoryId) {
        this.dormitoryMapper.deleteById(dormitoryId);
    }

    @Override
    public void save(Dormitory dormitory) {
        this.dormitoryMapper
                .save(dormitory);
    }

    @Override
    public void delete(Integer id) {
        try {
            List<Integer> studentIdList = this.dormitoryMapper.listStudentIdByDormitoryId(id);
            this.dormitoryMapper.delete(id);
            for(Integer studentId : studentIdList){
                Integer availableDormitoryId = this.dormitoryMapper.availableDormitoryId();
                this.transferStudent(studentId, availableDormitoryId);
                this.dormitoryMapper.subAvailable(availableDormitoryId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Dormitory dormitory) {
        this.dormitoryMapper.update(dormitory);
    }

    @Override
    public List<Dormitory> search(String key, String value) {
        if (value.equals("")){
            return this.dormitoryMapper.listAll();
        }
        else {
            switch (key){
                case "name":
                    return this.dormitoryMapper.searchByName(value);
                case "telephone":
                    return this.dormitoryMapper.searchByTelephone(value);
                default:
                    return this.dormitoryMapper.listAll();
            }
        }
    }

    @Override
    public List<Dormitory> findByBuildingId(Integer buildingId) {
        return this.dormitoryMapper.findByBuildingId(buildingId);
    }
}

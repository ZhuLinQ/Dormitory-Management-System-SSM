package com.zlq.service.impl;

import com.zlq.mapper.BuildingMapper;
import com.zlq.mapper.DormitoryMapper;
import com.zlq.pojo.Building;
import com.zlq.service.BuildingService;
import com.zlq.service.DormitoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    private BuildingMapper buildingMapper;

    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private DormitoryMapper dormitoryMapper;

    @Override
    public List<Building> list() {
        return this.buildingMapper.list();
    }

    @Override
    public List<Building> search(String key, String value) {
        if(value.equals("")){
            return this.buildingMapper.list();
        }
        switch ( key){
            case "name":
                return this.buildingMapper.searchByName(value);
            case "introduction":
                return this.buildingMapper.searchByIntroduction(value);
            default:
                return this.buildingMapper.list();
        }
    }

    @Override
    public void save(Building building) {
        this.buildingMapper.save(building);
    }

    @Override
    public void update(Building building) {
        this.buildingMapper.update(building);
    }

    @Override
    public void delete(Integer id) {
        //找到楼宇包含的所有宿舍；
        List<Integer> dormitoryIdList = this.buildingMapper.listDormitoryIdByBuildingId(id);

        for (Integer dormitoryId : dormitoryIdList) {
            // 找到宿舍包含的所有学生
            List<Integer> studentIdList = this.dormitoryService.listStudentIdByDormitoryId(dormitoryId);
            //删除宿舍
            this.dormitoryService.deleteById(dormitoryId);
            for (Integer studentId : studentIdList) {
                // 学生调换宿舍
                Integer availableDormitoryId = this.dormitoryService.findAvailableDormitoryId();
                this.dormitoryService.transferStudent(studentId, availableDormitoryId);
                this.dormitoryMapper.subAvailable(availableDormitoryId);
            }
        }

        //删除楼宇
        this.buildingMapper.deleteById(id);
    }
}

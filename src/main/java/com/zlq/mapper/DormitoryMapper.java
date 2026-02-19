package com.zlq.mapper;

import com.zlq.pojo.Dormitory;

import java.util.List;

public interface DormitoryMapper {
    public void deleteById(Integer id);

    public List<Dormitory> availableList();
    public void subAvailable(int id);
    public void addAvailable(int id);

    public List<Integer> listStudentIdByDormitoryId(Integer dormitoryId);

    public Integer availableDormitoryId();

    public void transferStudent(Integer studentId, Integer availableDormitoryId);

    public List<Dormitory> listAll();

    public void save(Dormitory dormitory);

    public void delete(Integer id);

    public void update(Dormitory dormitory);

    public List<Dormitory> searchByName(String value);
    public List<Dormitory> searchByTelephone(String value);

    public List<Dormitory> findByBuildingId(Integer buildingId);
}

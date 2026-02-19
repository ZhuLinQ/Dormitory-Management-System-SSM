package com.zlq.service;

import com.zlq.pojo.Dormitory;

import java.util.List;

public interface DormitoryService {
    public List<Dormitory> listAll();
    public List<Dormitory> listAvailable();
    public Integer findAvailableDormitoryId();
    public List<Integer> listStudentIdByDormitoryId(java.lang.Integer dormitoryId);

    public void transferStudent(Integer studentId, Integer availableDormitoryId);

    public void deleteById(Integer dormitoryId);

    public void save(Dormitory dormitory);
    public void delete(Integer id);

    public void update(Dormitory dormitory);

    public List<Dormitory> search(String key, String value);
    public List<Dormitory> findByBuildingId(Integer buildingId);
}

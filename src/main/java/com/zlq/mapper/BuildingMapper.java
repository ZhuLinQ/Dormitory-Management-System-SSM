package com.zlq.mapper;

import com.zlq.pojo.Building;

import java.util.List;

public interface BuildingMapper {
    public List<Building> list();
    public List<Building> searchByName(String value);
    public List<Building> searchByIntroduction(String value);

    public void save(Building building);

    public void update(Building building);

    public List<Integer> listDormitoryIdByBuildingId(Integer id);

    public void deleteById(Integer id);
}

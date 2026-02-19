package com.zlq.service.impl;

import com.zlq.mapper.DormitoryAdminMapper;
import com.zlq.pojo.DormitoryAdmin;
import com.zlq.service.DormitoryAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;


@Service
public class DormitoryAdminServiceImpl implements DormitoryAdminService {

    @Autowired
    private DormitoryAdminMapper dormitoryAdminMapper;

    @Override
    public List<DormitoryAdmin> list() {
        return this.dormitoryAdminMapper.list();
    }

    @Override
    public List<DormitoryAdmin> search(String key, String value) {
        if(value.equals(""))    return this.dormitoryAdminMapper.list();
        switch ( key){
            case "username":
                return this.dormitoryAdminMapper.searchByUsername(value);
            case "name":
                return this.dormitoryAdminMapper.searchByName(value);
            case "telephone":
                return this.dormitoryAdminMapper.searchByTelephone(value);
            default:
                return null;
        }
    }
    @Override
    public void save(DormitoryAdmin dormitoryAdmin) {
        try {
            this.dormitoryAdminMapper.save(dormitoryAdmin);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Integer id){
        try {
            this.dormitoryAdminMapper.delete(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(DormitoryAdmin dormitoryAdmin) {
        this.dormitoryAdminMapper.update(dormitoryAdmin);
    }

}

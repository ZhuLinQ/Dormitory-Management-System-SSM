package com.zlq.service;

import com.zlq.pojo.Absent;

import java.util.List;

public interface AbsentService {
    public List<Absent> list();
    public List<Absent> search(String key,String value);
    public void save(Absent absent);
}

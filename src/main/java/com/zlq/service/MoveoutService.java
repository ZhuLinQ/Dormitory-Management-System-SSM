package com.zlq.service;

import com.zlq.pojo.Moveout;

import java.util.List;

public interface MoveoutService {
    public List<Moveout> list();

    public List<Moveout> search(String key, String value);
}

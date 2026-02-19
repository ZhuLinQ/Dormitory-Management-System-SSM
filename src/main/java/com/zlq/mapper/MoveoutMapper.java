package com.zlq.mapper;

import com.zlq.pojo.Moveout;

import javax.swing.*;
import java.util.List;

public interface MoveoutMapper {
    public List<Moveout> list();

    public List<Moveout> searchByStudentName(String value);
    public List<Moveout> searchByDormitoryName(String value);
}

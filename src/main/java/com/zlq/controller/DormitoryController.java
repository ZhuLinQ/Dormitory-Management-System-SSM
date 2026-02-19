package com.zlq.controller;

import com.zlq.mapper.DormitoryMapper;
import com.zlq.pojo.Dormitory;
import com.zlq.pojo.Student;
import com.zlq.service.BuildingService;
import com.zlq.service.DormitoryService;
import com.zlq.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/dormitory")
public class DormitoryController {
    @Autowired
    private DormitoryService dormitoryService;
    @Autowired
    private BuildingService buildingService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("dormitorymanager");
        mv.addObject("list",this.dormitoryService.listAll());

        mv.addObject(
                "buildingList",
                this.buildingService.list()
        );
        return mv;
    }

    @PostMapping("/save")
    public String save(Dormitory dormitory){
        this.dormitoryService.save(dormitory);
        return "redirect:/dormitory/list";
    }
    @PostMapping("/delete")
    public String delete(Integer id){
        this.dormitoryService.delete(id);
        return "redirect:/dormitory/list";
    }


    @PostMapping("/update")
    public String update(Dormitory dormitory){
        this.dormitoryService.update(dormitory);
        return "redirect:/dormitory/list";
    }

    @RequestMapping("/search")
    public ModelAndView search(String key,String value){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("dormitorymanager");
        mv.addObject("list",this.dormitoryService.search(key,value));

        mv.addObject(
                "buildingList",
                this.buildingService.list()
        );
        return mv;
    }


    @PostMapping("/findByBuildingId")
    @ResponseBody
    public List findByBuildingId(Integer buildingId){
        List list = new ArrayList();
        List<Dormitory> dormitoryList = this.dormitoryService.findByBuildingId(buildingId);
        if(dormitoryList.size() == 0){
            list.add(new ArrayList<>());
            list.add(new ArrayList<>());
            return list;
        }
        List<Student> studentList = this.studentService.findByDormitoryId(dormitoryList.get(0).getId());

        list.add(dormitoryList);
        list.add(studentList);
        return list;
    }
}

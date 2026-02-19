package com.zlq.controller;


import com.zlq.pojo.DormitoryAdmin;
import com.zlq.service.impl.DormitoryAdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dormitoryAdmin")
public class DormitoryAdminController {
    @Autowired
    private DormitoryAdminServiceImpl dormitoryAdminServiceImpl;

    @GetMapping("/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminmanager");
        modelAndView.addObject("list", dormitoryAdminServiceImpl.list());
        return modelAndView;
    }

    @PostMapping("/search")
    public ModelAndView search(String key,String value){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminmanager");
        modelAndView.addObject("list", dormitoryAdminServiceImpl.search(key,value));
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(DormitoryAdmin dormitoryAdmin){
        this.dormitoryAdminServiceImpl.save(dormitoryAdmin);
        return  "redirect:/dormitoryAdmin/list";
    }

    @PostMapping("/delete")
    public String delete(Integer id){
        this.dormitoryAdminServiceImpl.delete(id);
        return "redirect:/dormitoryAdmin/list";
    }

    @PostMapping("update")
    public String update(DormitoryAdmin dormitoryAdmin){
        this.dormitoryAdminServiceImpl.update(dormitoryAdmin);
        return "redirect:/dormitoryAdmin/list";
    }

}

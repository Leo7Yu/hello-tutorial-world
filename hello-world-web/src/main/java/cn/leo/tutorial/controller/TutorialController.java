package cn.leo.tutorial.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.leo.spring.service.TutorialService;

//http://localhost:8080/hello-world-web/tutoril/getInt?number=2

@Controller
@RequestMapping("/tutoril/")
public class TutorialController {

    @Resource
    private TutorialService tutorialService;
    
    @RequestMapping(path = "index",method=RequestMethod.GET)
    @ResponseBody
    public ModelAndView index(){
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("tutorial/index", model);
    }
    
    @RequestMapping(path = "getInt")
    @ResponseBody
    public Integer getInteger(Integer number){
        return tutorialService.getInt(number);
    }
}

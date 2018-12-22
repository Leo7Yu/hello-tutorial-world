package cn.leo.tutorial.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.leo.spring.service.TutorialService;

@Controller
@RequestMapping("/tutoril/")
@Slf4j
public class TutorialController {

    @Resource
    private TutorialService tutorialService;

    // http://localhost:8080/hello-world-web/tutoril/index
    @RequestMapping(path = "index", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index() {
        Map<String, Object> model = new HashMap<>();
        return new ModelAndView("tutorial/index", model);
    }

    // http://localhost:8080/hello-world-web/tutoril/getInt?number=2
    @RequestMapping(path = "getInt")
    @ResponseBody
    public Integer getInteger(Integer number) {
        log.debug("in getInteger...");
        return tutorialService.getInt(number);
    }

    // http://localhost:8080/hello-world-web/tutoril/addAid?aid=2
    @RequestMapping(path = "addAid")
    @ResponseBody
    public Integer addAid(Integer aid) {
        log.debug("in getInteger...");
        int insertResult=0;
        try {
            insertResult=tutorialService.helloTransaction(aid);
        } catch (Exception e) {
            insertResult=-1;
        }
        return insertResult;
    }
}

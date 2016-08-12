package cn.leo.spring.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.leo.spring.dao.mybatis.activity.LotteryConfigDao;
import cn.leo.spring.service.TutorialService;

@Service
public class TutorialServiceImpl implements TutorialService {
    
    @Resource
    private LotteryConfigDao lotteryConfigDao;

    @Override
    public int getInt(int number) {
        return lotteryConfigDao.selectAidById(number)+1;
    }

    
}

package cn.leo.spring.service.impl;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.leo.spring.dao.mybatis.activity.LotteryConfigDao;
import cn.leo.spring.service.TutorialService;

@Service
public class TutorialServiceImpl implements TutorialService {
    private static final Logger logger = LoggerFactory
            .getLogger(TutorialServiceImpl.class);

    @Value("${runtime.env}")
    String runtimeEnv;

    @Resource
    private LotteryConfigDao lotteryConfigDao;

    @Override
    public int getInt(int number) {
        logger.debug("runtimeEnv:{}", runtimeEnv);
        return lotteryConfigDao.selectAidById(number) + number;
    }
    
    
    /**
     * 只有RuntimeException才会使回滚生效
     */
    @Override
    @Transactional
    public int helloTransaction(int aid){
        int insertResult = lotteryConfigDao.insertLotteryAid(aid);
        logger.debug("insertLotteryAid result:{}", insertResult);
            if(getTrue()){
                throw new RuntimeException();
            }
        return insertResult;
    }

    private boolean getTrue() {
        return true;
    }
}

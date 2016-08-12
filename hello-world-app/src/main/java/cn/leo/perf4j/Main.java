package cn.leo.perf4j;

import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;
import org.perf4j.slf4j.Slf4JStopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//java -jar work/.m2/repository/org/perf4j/perf4j/0.9.16/perf4j-0.9.16.jar aliyun/logs/app.log -t 300000 //单位毫秒

//java -jar work/.m2/repository/org/perf4j/perf4j/0.9.16/perf4j-0.9.16.jar --graph perfGraphs.html aliyun/logs/app.log

//tail -f performance.log | java -jar perf4j-0.9.8.1.jar  

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        logger.debug("start perf4j tutaorial...");

        StopWatch stopWatch = new Slf4JStopWatch("email");
//        stopWatch = new Log4JStopWatch("email");
        long startTime = stopWatch.getStartTime();
        logger.debug("{} startTime:{}", stopWatch.getTag(), startTime);

        stopWatch.stop();//stop会将信息打印
        
        Thread.sleep(100);
        stopWatch.start("phone");// start后重新开始计时,tag会随着每次设置改变

        startTime = stopWatch.getStartTime();
        logger.debug("{} startTime:{}", stopWatch.getTag(), startTime);

        Thread.sleep(100);
        stopWatch.start("sms");

        startTime = stopWatch.getStartTime();
        logger.debug("{} startTime:{}", stopWatch.getTag(), startTime);

        Thread.sleep(300);
        logger.debug("ElapsedTime:{}", stopWatch.getElapsedTime());//ElapsedTime是从开始到结束的时间差，单位毫秒

        stopWatch.start();
        Thread.sleep(100);
        
        stopWatch.lap("tag1");//从开始到现在的时间信息,会将log信息打印到日志
        Thread.sleep(90);
        logger.debug(stopWatch.lap("tag2"));//从上次lap到现在的时间信息
        Thread.sleep(80);
        logger.debug(stopWatch.lap("tag3"));
        
        stopWatch.stop();//stop会打印log信息

    }

}

package cn.leo.perf4j;

import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainLog {
    private static final Logger logger = LoggerFactory.getLogger(MainLog.class);
    
    public static void main(String[] args) throws InterruptedException {
       StopWatch stopWatch=new Log4JStopWatch("email");
       Thread.sleep(10);
       stopWatch.stop("email");
       
       stopWatch.start();
       
       Thread.sleep(10);
       
       stopWatch.stop();
    }

}

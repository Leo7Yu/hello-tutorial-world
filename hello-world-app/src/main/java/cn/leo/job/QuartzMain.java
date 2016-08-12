package cn.leo.job;

import java.text.ParseException;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobDetail;  
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import  org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzMain {
    public static void main(String[] args) throws ParseException, SchedulerException, InterruptedException {
        SchedulerFactory schedFact=new StdSchedulerFactory();
        Scheduler sched=schedFact.getScheduler();
        
        JobDetail jobDetail = new JobDetail("lzstoneJob","testGroup",QuartzReport.class);
        
        CronTrigger trigger=new  CronTrigger("lzstoneJob","testGroup","0 38 12 * * ?");
        
        sched.scheduleJob(jobDetail,trigger);
        sched.start();
        
        Thread.sleep(10*60*1000);
        
    }

    public static class QuartzReport implements Job {
        public void execute(JobExecutionContext arg0)
                throws JobExecutionException {
            System.out.println("in QuartzReport execute...");
        }

    }
}

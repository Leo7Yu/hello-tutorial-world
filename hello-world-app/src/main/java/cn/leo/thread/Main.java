package cn.leo.thread;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class Main {
    
    public static void main(String[] args) {
        @SuppressWarnings({ "resource" })
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:spring/config-service.xml");
        ThreadPoolTaskExecutor taskExecutor = context
                .getBean(ThreadPoolTaskExecutor.class);
        taskExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("in testExecutor...");
            }
        });
    }
    
}

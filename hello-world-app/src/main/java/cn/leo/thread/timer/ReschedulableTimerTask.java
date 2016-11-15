package cn.leo.thread.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.lang.reflect.Field;

/** 
 * @author LeoYu 
 * @date 2016年11月15日 上午10:25:51 
 * 动态改变执行周期。间接性 
 */

public class ReschedulableTimerTask extends TimerTask {
    private  boolean isLongPeriod=false;
    private long lastRunTime;
    
    @Override
    public void run() {
        if(isLongPeriod){
            setPeriod(3000,false);
        }else{
            setPeriod(1000,true);
        }
        
        long currentTime=System.currentTimeMillis();
        if(lastRunTime>0){
            System.out.println("period:"+(currentTime-lastRunTime));
        }else{
            System.out.println("new...");
        }
        lastRunTime=currentTime;
    }

    private void setPeriod(int period, boolean isLongPeriod) {
        this.isLongPeriod=isLongPeriod;
        try {
            Field field=TimerTask.class.getDeclaredField("period");
            field.setAccessible(true);
            field.set(this,period);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        ReschedulableTimerTask timerTask=new ReschedulableTimerTask();
//        Timer timer = new Timer();
//        long delay = 1000;
//        timer.schedule(timerTask, delay, 2000);
        System.out.println(isDayTime());
    }
    
    private static Date[] dayRange;
    
    private static boolean isDayTime() {
        //白天：（8：00-22：00）
        //夜间：（22：00-8：00）
        Date now=new Date();
        if(dayRange==null){
            synchronized (ReschedulableTimerTask.class) {
                if(dayRange==null){
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(now);
                    calendar.set(Calendar.HOUR_OF_DAY, 8);
                    calendar.set(Calendar.MINUTE, 0);
                    calendar.set(Calendar.SECOND, 0);
                    Date dayBegin=calendar.getTime();
                    
                    calendar.set(Calendar.HOUR_OF_DAY, 22);
                    Date dayEnd=calendar.getTime();
                    System.out.println(dayBegin);
                    System.out.println(dayEnd);
                    dayRange=new Date[]{dayBegin,dayEnd};
                }
            }
        }
        
        if(now.after(dayRange[0])&&now.before(dayRange[1])){
            return true;
        }
        return false;
    }
}

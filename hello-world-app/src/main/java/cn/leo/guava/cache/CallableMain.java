package cn.leo.guava.cache;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * 
 * @author Leo yujf77@qq.com tutorial
 *         url:http://ifeve.com/google-guava-cachesexplained/
 */
public class CallableMain {

    public static void main(String[] args) {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(1000).expireAfterWrite(10, TimeUnit.SECONDS)
                .build();
        try {
            final String key = "test";
            String result = cache.get(key, new Callable<String>() {
                public String call() throws Exception {
                    System.out.println(key);
                    return "result:"+key;
                }
            });
            
            System.out.println(result);
            
            MyCallable callable=new MyCallable("test");
            result=cache.get("test", callable);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public static class MyCallable implements Callable<String>{
        private String key;
        public MyCallable(String key){
            this.key=key;
        }
        
        public String call() throws Exception {
            System.out.println(key);
            return "result:"+key;
        }
        
    }
}

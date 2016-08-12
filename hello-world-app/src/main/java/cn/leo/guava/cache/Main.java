package cn.leo.guava.cache;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

/**
 * 
 * @author Leo yujf77@qq.com tutorial
 *         url:http://ifeve.com/google-guava-cachesexplained/
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        LoadingCache<String, Object> graphs = CacheBuilder.newBuilder()
                .maximumSize(1000).expireAfterWrite(10, TimeUnit.SECONDS)
                .build(new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String key) throws Exception {
                        return createExpensiveGraph(key);
                    }

                    private Object createExpensiveGraph(String key) {
                        System.out.println("in createExpensiveGraph: " + key
                                + ": " + new Date());
                        return "sssss";
                    }
                });
        try {
            String result = (String) graphs.get("test");// 此处会触发createExpensiveGraph，因为第一次加载
            System.out.println(result);
            Thread.sleep(10);
            result = (String) graphs.get("test");// 此处不会触发，因为10秒内加载过了
            System.out.println(result);
            Thread.sleep(11 * 1000);
            result = (String) graphs.get("test");// 此处会触发createExpensiveGraph，因为第一次加载10秒后触发
            System.out.println(result);
            System.out.println("---------------------------------");
            result = (String) graphs.get("test1");//触发因为取新的key
            System.out.println(result);
            Thread.sleep(5 * 1000);
            graphs.put("test1", "ss");
            result = (String) graphs.get("test1");// 不触发因为刚put
            System.out.println(result);
            Thread.sleep(5 * 1000);
            result = (String) graphs.get("test1");// 不触发因为只睡了5秒不到10秒
            System.out.println(result);
            Thread.sleep(6 * 1000);
            result = (String) graphs.get("test1");// 触发因为超过10秒了
            System.out.println(result);
            System.out.println("---------------------------------");
            graphs.invalidate("test1");
            result = (String) graphs.get("test1");// 触发因为之前invalidate
            System.out.println(result);
            System.out.println("---------------------------------");
            result = (String) graphs.getIfPresent("test2");// 不触发
            System.out.println(result);//返回null
            graphs.put("test2", "myTest");
            result = (String) graphs.getIfPresent("test2");// 不触发
            System.out.println(result);//返回myTest

        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

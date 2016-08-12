package cn.leo.redis.main;

import java.util.Date;
import java.util.List;

import cn.leo.redis.util.JedisUtil;
import cn.leo.redis.util.PropsHelper.PropKeyEnum;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class JedisPoolMain {

	public static void main(String[] args) {
		String host = PropKeyEnum.REDIS_HOST.getProp();
		int port = Integer.parseInt(PropKeyEnum.REDIS_PORT.getProp());
		int timeout = Integer.parseInt(PropKeyEnum.REDIS_TIMEOUT.getProp());
		JedisUtil jedisUtil=JedisUtil.getInstance();
		
		Jedis jedis=null;
		try {
			jedis=jedisUtil.getJedis(host, port, timeout);
			testUsePipeline(jedis);
		} finally {
			if(jedis!=null){
				jedisUtil.closeJedis(jedis, host, port, timeout);
			}
		}
		
//		try {
//			jedis=jedisUtil.getJedis(host, port, timeout);
//			testUsePipeline(jedis);
//		} finally {
//			if(jedis!=null){
//				jedisUtil.closeJedis(jedis, host, port, timeout);
//			}
//		}
	}
	
	
	private static void testUsePipeline(Jedis jedis) {  
        long start = new Date().getTime();  
        jedis.flushDB();  
        Pipeline p = jedis.pipelined();  
        for (int i = 0; i < 10; i++) {  
            p.set("age2" + i, i + "");
            p.get("age2" + i);
//            System.out.print(p.get("age2" + i)+"  ");  //����:Response string,���᷵��iֵ
        }  
        List<Object> responseList=p.syncAndReturnAll();// ��δ����ȡ���е�response
        //�������Ҫ����ֵ��ʹ��p.sync()
        for (Object object : responseList) {
//			System.out.print(object+",");//��ӡ��set��get�ķ���ֵok��iֵ
		}
   
        jedis.flushDB();
        
        long end = new Date().getTime();  
        System.out.println("use pipeline cost:" + (end - start) + "ms");  
    }  
}

package cn.leo.redis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.leo.redis.util.PropsHelper.PropKeyEnum;
import redis.clients.jedis.Jedis;

public class RedisService {
	private Jedis jedis;

	public RedisService() {
		jedis = getJedis();
	}

	public Jedis getJedis() {
		String host = PropKeyEnum.REDIS_HOST.getProp();
		int port = Integer.parseInt(PropKeyEnum.REDIS_PORT.getProp());
		// String pw = PropKeyEnum.REDIS_PW.getProp();
		int timeout = Integer.parseInt(PropKeyEnum.REDIS_TIMEOUT.getProp());

		Jedis jedis = new Jedis(host, port, timeout);
		System.out.println("host:" + host);
		return jedis;
	}

	public void operateString() {
		String pResult = jedis.ping();
		System.out.println(pResult);

		String setResult=jedis.set("tutorial-key", "redis tutorial");
		String value = jedis.get("tutorial-key");
		System.out.println("set string: "+setResult+": "+value);
		
		jedis.setex("tutorial-key-ex",10,"redis content for 10 secends");
		
		//NX -- Only set the key if it does not already exist. 
	    //XX -- Only set the key if it already exist.
		//EX|PX, expire time units: EX = seconds; PX = milliseconds
		jedis.set("tutorial-key","param1","XX","EX",5);
		value=jedis.get("tutorial-key");
		System.out.println("tutorial-key-test value: "+value);
		
		setResult=jedis.setex("tutorial-key", 6, "param2");
		System.out.println("setex result: "+setResult);
		
		Long setNXResult=jedis.setnx("tutorial-key", "setNX");
		System.out.println("setnx result: "+setNXResult);
		
		jedis.append("tutorial-key", ": my append");
		value = jedis.get("tutorial-key");
		System.out.println("after append: "+value);

		Long result = jedis.setnx("tutorial-key", "redis tutorial");
		System.out.println(result);
		
		jedis.mset("name","minxr","jarorwar","aaa");
		List<String> mgetResult=jedis.mget("name","jarorwar");
		System.out.println("mgetResult: "+mgetResult.toString());
	}

	public void operateList() {
		String list_key_name = "tutorial-list";
		jedis.lpush(list_key_name, "Redis");
		jedis.lpush(list_key_name, "Mongodb", "mysql");
		List<String> list = jedis.lrange(list_key_name, 0, 3);
		for (String value : list) {
			System.out.println("lrange value: " + value);
		}
	}

	public void operateKey() {
		Set<String> list = jedis.keys("*");
		for (String key : list) {
			System.out.println("key: " + key);
		}
	}

	public void operateSet() {
		jedis.sadd("tutorial-set", "1");
		jedis.sadd("tutorial-set","2" ,"3","4");
		Set<String> set=jedis.smembers("tutorial-set");
		for (String value : set) {
			System.out.println("set value:"+value);
		}
		
		jedis.srem("tutorial-set", "4");
		System.out.println(jedis.scard("tutorial-set"));
		System.out.println(jedis.sismember("tutorial-set", "4"));
		
		System.out.println(jedis.spop("tutorial-set"));//��ջ
		System.out.println(jedis.smembers("tutorial-set"));
	}

	public void operateZSet() {
		jedis.zadd("hackers", 1940, "Alan Kay");  
        jedis.zadd("hackers", 1953, "Richard Stallman");  
        jedis.zadd("hackers", 1965, "Yukihiro Matsumoto");  
        jedis.zadd("hackers", 1916, "Claude Shannon");  
        jedis.zadd("hackers", 1969, "Linus Torvalds");  
        jedis.zadd("hackers", 1912, "Alan Turing");  
        Set<String> setValues = jedis.zrange("hackers", 0, -1); //��score���� 
        System.out.println(setValues);  
        Set<String> setValues2 = jedis.zrevrange("hackers", 0, -1); //��score����  
        System.out.println(setValues2);  
        
        // Ԫ�ظ���  
        System.out.println(jedis.zcard("hackers"));  
        // Ԫ���±�  
        System.out.println(jedis.zscore("hackers", "Alan Turing"));  
         
        System.out.println(jedis.zcount("hackers", 1912, 1940)); 
        // ɾ��Ԫ��  
        System.out.println(jedis.zrem("hackers", "Alan Turing"));
        System.out.println(jedis.zcard("hackers"));  
	}
	
	public void operateHash() {
		Map<String,String> pairs=new HashMap<>();
		pairs.put("name", "Akshi");
		pairs.put("age", "2");
		pairs.put("sex", "Female");
		
		jedis.hmset("kid", pairs);
		
		List<String> name=jedis.hmget("kid", "name");
		System.out.println(name);
		List<String> attributes=jedis.hmget("kid", "name","age");
		System.out.println(attributes);
		
		System.out.println(jedis.hdel("kid", "age"));//ɾ����ֵ
		System.out.println(jedis.hkeys("kid")+"---"+jedis.hvals("kid"));
		
		// �������  
        System.out.println(jedis.flushDB());  
	}

}

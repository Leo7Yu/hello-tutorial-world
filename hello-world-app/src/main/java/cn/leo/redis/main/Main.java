package cn.leo.redis.main;

import cn.leo.redis.service.RedisService;


public class Main {

	public static void main(String[] args) {

		RedisService service=new RedisService();

		service.operateString();
		
		service.operateList();
	
		service.operateKey();
		
		service.operateSet();
		
		service.operateZSet();
		
		service.operateHash();
	}

}

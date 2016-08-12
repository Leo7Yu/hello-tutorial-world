package cn.leo.redis.util;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {

	private JedisUtil() {
	}

	private static Map<String, JedisPool> maps = new HashMap<String, JedisPool>();

	/**
	 * ��ȡ���ӳ�
	 */
	private static JedisPool getPool(String ip, int port,int timeout) {
		String key = ip + ":" + port;
		JedisPool pool = null;

		if (!maps.containsKey(key)) {
			synchronized (JedisUtil.class) {
				if (!maps.containsKey(key)) {
					System.out.println("doesn't contain key...");
					JedisPoolConfig config = new JedisPoolConfig();
					config.setMaxIdle(100);
					config.setMaxWaitMillis(1000000);
					config.setTestOnBorrow(true);
					config.setTestOnReturn(true);
					try {
						pool = new JedisPool(config, ip, port, timeout);
						maps.put(key, pool);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else {
					pool = maps.get(key);
				}
			}
		} else {
			System.out.println("contains key...");
			pool = maps.get(key);
		}
		return pool;
	}

	private static class RedisUtilHolder {
		private static JedisUtil instance = new JedisUtil();
	}

	public static JedisUtil getInstance() {
		return RedisUtilHolder.instance;
	}

	public Jedis getJedis(String ip, int port, int timeout) {
		Jedis jedis = null;
		int count = 0;
		do {
			try {
				jedis = getPool(ip, port,timeout).getResource();
			} catch (Exception e) {
				e.printStackTrace();
				getPool(ip, port,timeout).returnBrokenResource(jedis);
			}
			count++;
		} while (jedis == null && count < 10);

		return jedis;
	}

	public void closeJedis(Jedis jedis, String ip, int port,int timeout) {
		if (jedis != null) {
			getPool(ip, port,timeout).returnResource(jedis);
		}
	}
}

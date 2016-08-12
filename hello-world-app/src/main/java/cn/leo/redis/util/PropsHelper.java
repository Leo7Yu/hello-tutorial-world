package cn.leo.redis.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsHelper {
	private static final Properties prop;

	static {
		InputStream inStream = PropsHelper.class.getClassLoader().getResourceAsStream("conf/config.properties");
		prop = new Properties();
		try {
			prop.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static Properties getProp() {
		return prop;
	}

	public synchronized static final String getProperty(final String key) {
		return getProp().getProperty(key);
	}

	public static enum PropKeyEnum {
		REDIS_HOST("redis.host"), REDIS_PORT("redis.port"), REDIS_PW("redis.password"), REDIS_TIMEOUT("redis.timeout");

		private String key;

		private PropKeyEnum(String key) {
			this.key = key;
		}

		public String getProp(){
			return PropsHelper.getProperty(key);
		}
	}
}

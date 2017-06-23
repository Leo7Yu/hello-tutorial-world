package cn.leo.sign;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckSignMain {
	private static final List<String> EXCLUDE_SIGN_PARAMETER_NAMES = Arrays.asList(new String[] { "sig" });
	private static final String PRIVATE_KEY = "cWvJj78B6E4QhcumOfaU0dpB!GXu$Rfe";// 32位密钥

	public static void main(String[] args) {
		java.sql.Timestamp timestamp=new java.sql.Timestamp(2017, 03, 10, 14, 6, 14, 0);
		long time=timestamp.getTime();
		System.out.println(time/1000L);
		
		Date date=new Date();
		System.out.println(date.getTime()/1000L);
		
		Map<String, Object> params = new HashMap<>();
		params.put("eid", "10000"); // 企业标识
		params.put("orderno", "201703100000001");// 企业订单号

		String sig = getGig(params);
		System.out.println(sig);
	}

	private static String getGig(Map<String, Object> params) {
		StringBuilder sBuilder = new StringBuilder("eorder");

		List<String> paramNames = getSortedParameterNames(params);
		for (String name : paramNames) {
			sBuilder.append(name);
			sBuilder.append(params.get(name));
		}

		sBuilder.append(PRIVATE_KEY);

		String plainSign = sBuilder.toString();
		System.out.println("plain sig:" + plainSign);
		String sig = null;
//		sig = MD5Utils.md5(plainSign);

		return sig;
	}

	private static List<String> getSortedParameterNames(Map<String, Object> params) {
		List<String> keys = new ArrayList<String>();
		for (String key : params.keySet()) {
			if (EXCLUDE_SIGN_PARAMETER_NAMES.contains(key)) {
				continue;
			}
			keys.add(key);
		}
		Collections.sort(keys);
		return keys;
	}
}

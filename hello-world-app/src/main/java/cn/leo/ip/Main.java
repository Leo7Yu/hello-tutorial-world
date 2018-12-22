package cn.leo.ip;

import java.util.HashSet;
import java.util.Set;

public class Main {

	static Set<String> get(String ipMask) {
		String[] ipAndMask = ipMask.split("/");

		if (ipAndMask.length != 2) {
			return null;
		}
		String[] ips = ipAndMask[0].split("\\.");
		if (ips.length != 4) {
			return null;
		}

		int[] intIps = new int[4];
		for (int i = 0; i < ips.length; i++) {
			intIps[i] = Integer.parseInt(ips[i]);

//			String ipS = ips[i];
//			String test = Integer.toBinaryString(Integer.parseInt(ipS));
//			System.out.println(test);
		}

		int mask = 32 - Integer.parseInt(ipAndMask[1]);
		double maxIpNumber = Math.pow(2, mask) - 1;

		Set<String> set = new HashSet<>();
		int[] ipField = { 0, 0, 0, 0 };
		for (int i = 0; i < maxIpNumber; i++) {
			set.add((intIps[0] + ipField[0]) + "." + (intIps[1] + ipField[1]) + "." + (intIps[2] + ipField[2]) + "."
					+ (intIps[3] + ipField[3]++));
			for (int j = 3; j > 0; j--) {// 最高位不会大于255，所以不需要进位
				if (ipField[j] > 255) {
					ipField[j] = 0;
					ipField[j - 1] += 1;
				}
			}
		}

		return set;
	}

	public static void main(String[] args) {
		// Set<String> ips=get("100.68.136.128/25");
		Set<String> ips = get("106.11.128.0/24");
		for (String ip : ips) {
			System.out.println(ip);
		}
	}

}

package cn.leo.json.gson;

import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

import cn.leo.json.fastjson.SinopecNetChargeResp;

public class Main {
	private static Gson gson = new Gson();

	public static void main(String[] args) {
		String json = "{\"code\":\"0\",\"data\":{\"jsessionId\":\"00DF67D2B447CE76064F8CF4BCEA3AB3\"},\"msg\":\"\",\"timestamp\":1487910315}";

		// 使用GsonBuilder导出null值、格式化输出、日期时间
		// Gson gson = new GsonBuilder() //序列化null
		// .serializeNulls() // 设置日期时间格式，另有2个重载方法 // 在序列化和反序化时均生效
		// .setDateFormat("yyyy-MM-dd") // 禁此序列化内部类
		// .disableInnerClassSerialization() //生成不可执行的Json（多了 )]}' 这4个字符）
		// .generateNonExecutableJson() //禁止转义html标签
		// .disableHtmlEscaping() //格式化输出
		// .setPrettyPrinting() .create();

		SinopecNetChargeResp resp = gson.fromJson(json, SinopecNetChargeResp.class);

		String result = gson.toJson(resp, SinopecNetChargeResp.class);
		System.out.println(result);
	}
}

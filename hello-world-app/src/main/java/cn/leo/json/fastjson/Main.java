package cn.leo.json.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Main {

	public static void main(String[] args) {
		String json="{\"code\":\"3\",\"data\":3,\"msg\":\"\",\"timestamp\":1487910315}";
//		String json="{\"code\":\"0\",\"data\":{\"jsessionId\":\"00DF67D2B447CE76064F8CF4BCEA3AB3\"},\"msg\":\"\",\"timestamp\":1487910315}";
		
		SinopecNetChargeResp resp = JSON.parseObject(json, SinopecNetChargeResp.class);
		System.out.println(resp.code);
		if("0".equals(resp.code)){
			System.out.println(resp.data);
			SinopecNetChargeResp.Data data=JSON.parseObject(resp.data, SinopecNetChargeResp.Data.class);
			System.out.println(data.jsessionId);
			
		}else{
			System.out.println(resp.data);
		}
		System.out.println(resp.msg);
		
		
		JSONObject jsonObject=JSON.parseObject(json);
		int code=jsonObject.getInteger("code");
		System.out.println("code:"+code);
	}

}

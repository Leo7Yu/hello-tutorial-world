package cn.leo.json.fastjson;

public class SinopecNetChargeResp {

	public String code;
	public Data data;
	public String msg;
	public Long timestamp;
	
	public static class Data{
		public String jsessionId;
	}
}

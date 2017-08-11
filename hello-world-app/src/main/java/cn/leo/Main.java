package cn.leo;

import lombok.Getter;

public class Main {

	public static void main(String[] args) {
		EnterpriseCategory category=EnterpriseCategory.findByCode(2);
		if(category==EnterpriseCategory.TRAFFIC_MERCHANT){
			System.out.println(1);
		}else{
			System.out.println(2);
		}
	}
	
	
	
	
	@Getter
	public enum EnterpriseCategory {
		TELE(0, "电信行业"), TRAFFIC_MERCHANT(2, "流量商户");

		private int code;
		private String desc;

		private EnterpriseCategory(int code, String desc) {
			this.code = code;
			this.desc = desc;
		}

		public static EnterpriseCategory findByCode(Integer code) {
			if (code == null) {
				return null;
			}
			for(EnterpriseCategory c:values()){
				if (c.getCode() == code) {
					return c;
				}
			}
			return null;
		}
	}

}

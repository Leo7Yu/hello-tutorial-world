package cn.leo;

public class Main {

	public static void main(String[] args) {
		String remark="槽9第1张|10086,yecx";
		String[] config=remark.split("\\|");
		if(config.length<2){
			System.out.println("splite | error:"+remark);
		}
		remark=config[1];
		config=remark.split(",");
		if(config.length<2){
			System.out.println("splite , error:"+remark);
		}
		for (String string : config) {
			System.out.println(string);
		}
	}

}

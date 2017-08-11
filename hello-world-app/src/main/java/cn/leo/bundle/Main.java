package cn.leo.bundle;

import java.util.ResourceBundle;

public class Main {

	public static void main(String[] args) {
		ResourceBundle resourceBundle=ResourceBundle.getBundle("TrustMerchant");
		String method=resourceBundle.getString("TrustPayConnectMethod");
		System.out.println("method:"+method);

	}

}

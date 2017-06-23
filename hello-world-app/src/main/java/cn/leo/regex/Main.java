package cn.leo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	private static Pattern cardnoErrorPattern = Pattern.compile("卡\\[([0-9]{19})\\](验证|充值)失败");
	
	public static void main(String[] args) {
		String message="加油卡[1000114400018914163]充值失败!";
		
		Matcher matcher =cardnoErrorPattern.matcher(message);
		if(matcher.find()){
			System.out.println("find");
		}else{
			System.out.println("not find");
		}
	}

}

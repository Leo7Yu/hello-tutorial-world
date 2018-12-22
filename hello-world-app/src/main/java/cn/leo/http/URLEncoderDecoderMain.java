package cn.leo.http;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderDecoderMain {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String result="https%3A%2F%2Fpages.tmall.com%2Fwow%2Fwt%2Fact%2Fgmcchh-result-proxy%3ForderId%3D2320003193030000001";
		String url=URLDecoder.decode(result, "UTF-8");  
		System.out.println(url);
		System.out.println(result);
		result=URLEncoder.encode(url, "UTF-8");  
		System.out.println(result);
	}

}

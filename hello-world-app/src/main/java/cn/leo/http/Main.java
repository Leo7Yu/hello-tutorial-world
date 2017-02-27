package cn.leo.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class Main {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		System.out.println(1111);
		
		HttpClient httpClient=HttpClients.createDefault();
		HttpPost hPost=new HttpPost("http://192.168.2.5/portal/scratch/lotteryaward.do");
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("phone", "15110263493"));
		params.add(new BasicNameValuePair("lotteryId", "3"));
		params.add(new BasicNameValuePair("activityId", "101"));
		params.add(new BasicNameValuePair("couponId", "201002"));
		params.add(new BasicNameValuePair("source", "11"));
		hPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
		
		HttpResponse response=httpClient.execute(hPost);
		HttpEntity entity=response.getEntity();
		if(entity!=null){
			InputStream in=entity.getContent();
			BufferedReader reader=new BufferedReader(new InputStreamReader(in));
			String line;
			try {
				while((line=reader.readLine())!=null){
					System.out.println(line);
				}
			} finally {
				in.close();
			}
		}
		
	}
}



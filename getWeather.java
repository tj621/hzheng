package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class getWeather {
	private static final String code="8924d0a789dd4e348982cfe7f721267c";
	
	getWeather(String cityName) {
		String weather=getWeather(cityName);
		System.out.println(weather);
		getTemp(weather);
		
	}
	
	public static void main(String[] msgn){
		getWeather g1=new getWeather("jiading");
	}
	
	public String getWeather(String city) {
		String heUrl="https://api.heweather.com/x3/weather?city=";
		StringBuffer strbuf = null;
		heUrl=heUrl+city+"&key="+code;
		strbuf=new StringBuffer();
		try {
			URL url=new URL(heUrl);
			URLConnection conn=url.openConnection();
			BufferedReader reader=new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line=null;
			while((line=reader.readLine())!=null){
				strbuf.append(line+"");
			}
			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}catch(IOException e1){
			e1.printStackTrace();
		}
		return strbuf==null?"error":strbuf.toString();
	}
	
	
	public void getTemp(String strPar){
		JSONObject dataOfJson=JSONObject.fromObject(strPar);
		JSONArray array=dataOfJson.getJSONArray("HeWeather data service 3.0");
		JSONObject aqi=array.getJSONObject(0);
		JSONObject now=aqi.getJSONObject("now");
		String temp=now.getString("tmp");
		System.out.println(temp);
	}
	
	

}

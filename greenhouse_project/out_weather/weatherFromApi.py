'''
Created on 2016年6月2日

@author: Zxh
'''
# -*- coding: utf-8 -*-
import urllib.request 
import json
from out_weather.weather_dao import DailyWeather

url = 'https://api.heweather.com/x3/weather?city=jiading&key=8924d0a789dd4e348982cfe7f721267c' 
class getWeatherJson():
    def doit(self):
        return getWeathertoJson()
def getWeatherData(DailyWeather):  
    data = urllib.request.urlopen(url).read() 
    wea_json = json.loads(bytes.decode(data))
    wea_json=wea_json['HeWeather data service 3.0'][0]
    upDatetime=wea_json['basic']['update']['loc']
    temperature=wea_json['now']['tmp']
    humidity=wea_json['now']['hum']
    par='no'
    co2='no'
    wind_dir=wea_json['now']['wind']['dir']
    wind_speed=wea_json['now']['wind']['spd']
    rain=wea_json['now']['pcpn']
    if (float(rain))>1.0:
        rain='1'   #raining
    else:
        rain='0'   #no rain
    pressure=wea_json['now']['pres']
    DailyWeather.setDailyWeather(upDatetime, temperature, humidity, par, co2, wind_dir, wind_speed, rain, pressure)
    return DailyWeather
def getWeathertoJson():
    dw=DailyWeather()
    getWeatherData(dw)
    hehe=dw.classtoJson()
    return json.loads(hehe)
ad=getWeatherJson()
print(ad.doit())
# print(json.loads(hehe))
# print(json.loads(hehe)['out_weather'])


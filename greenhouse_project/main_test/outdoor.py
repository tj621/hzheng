'''
Created on 2016年6月12日

@author: Zxh
'''
from builtins import classmethod
from pip._vendor.requests.models import json
import urllib
import time


class Outdoor(object):
    updateTime="2016/06/01"
    temperature='0'
    humidity='80'
    radiation='123'
    co2='500'
    wind_direction='东南风'
    wind_speed='4'
    rain="true"
    atmosphere='1111'
    @classmethod
    def __init__(self):
        self.update_time=time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time()))
        
    def setDailyWeather(self,update_time1,temperature1,humidity1,radiation1,co21,wind_direction1,wind_speed1,rain1,atmosphere1):
        self.update_time=update_time1;
        self.temperature=temperature1
        self.humidity=humidity1
        self.radiation=radiation1;
        self.co2=co21
        self.wind_direction=wind_direction1
        self.wind_speed=wind_speed1
        self.rain=rain1
        self.atmosphere=atmosphere1
        
    def set_updateTime(self):
        self.updateTime=time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time()))
    @classmethod    
    def getupdate_time(self):
        return self.update_time
    @classmethod
    def getTemperature(self):
        return self.temperature
    @classmethod
    def gethumidity(self):
        return self.humidity
    @classmethod
    def getradiation(self):
        return self.radiation
    @classmethod
    def getCo2(self):
        return self.co2
    @classmethod
    def getwind_direction(self):
        return self.wind_direction
    @classmethod
    def getWind_speed(self):
        return self.wind_speed
    @classmethod
    def getRain(self):
        return self.rain
    @classmethod
    def getatmosphere(self):
        return self.atmosphere
    @classmethod
    def setupdate_time(self,update_time):
        self.update_time=update_time;
    @classmethod
    def sethumidity(self,humidity):
        self.humidity=humidity;
    @classmethod
    def setradiation(self,radiation):
        self.radiation=radiation;
    @classmethod
    def setco2(self,co2):
        self.co2=co2;
    @classmethod
    def setwind_direction(self,wind_direction):
        self.wind_direction=wind_direction;
    @classmethod
    def setwind_speed(self,wind_speed):
        self.wind_speed=wind_speed;
    @classmethod
    def setrain(self,rain):
        self.rain=rain;
    @classmethod
    def setatmosphere(self,atmosphere):
        self.atmosphere=atmosphere;  
    @classmethod
    def settemperature(self,value):
        self.temperature=value;   
    @classmethod
    def classtoJson(self):
        return '''
        {"outdoor":{
            "update_time":"%s",
            "temperature":"%s",
            "humidity":"%s",
            "radiation":"%s",
            "co2":"%s",
            "wind_direction":"%s",
            "wind_speed":"%s",
            "rain":"%s",
            "atmosphere":"%s"
            }
        }'''\
        % (self.update_time, self.temperature, self.humidity, self.radiation, self.co2,self.wind_direction,self.wind_speed,self.rain,self.atmosphere)
    def getWeatherFromApi(self):
        url = 'https://api.heweather.com/x3/weather?city=jiading&key=8924d0a789dd4e348982cfe7f721267c'
        data = urllib.request.urlopen(url).read() 
        wea_json = json.loads(bytes.decode(data))
        wea_json=wea_json['HeWeather data service 3.0'][0]
        update_time=wea_json['basic']['update']['loc']
        temperature=str(wea_json['now']['tmp'])
        humidity=str(wea_json['now']['hum'])
        radiation='no'
        co2='no'
        wind_direction=wea_json['now']['wind']['dir']
        wind_speed=str(wea_json['now']['wind']['spd'])
        rain=wea_json['now']['pcpn']
        if (float(rain))>1.0:
            rain='true'   #raining
        else:
            rain='false'   #no rain
        atmosphere=str(wea_json['now']['pres'])
        Outdoor.setDailyWeather(update_time, temperature, humidity, radiation, co2, wind_direction, wind_speed, rain, atmosphere)
# test
# a=Outdoor()
# a.getWeatherFromApi()
# print(a.classtoJson())     
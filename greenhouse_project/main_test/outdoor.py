'''
Created on 2016年6月12日

@author: Zxh
'''
from builtins import classmethod
from pip._vendor.requests.models import json
import urllib


class Outdoor(object):
    update_time="2016/06/01"
    temperature='0'
    humidity='80'
    radiation='123'
    co2='500'
    wind_direction='东南风'
    wind_speed='4'
    rain="true"
    atmosphere='1111'
    @classmethod
    def setDailyWeather(cls,update_time1,temperature1,humidity1,radiation1,co21,wind_direction1,wind_speed1,rain1,atmosphere1):
        cls.update_time=update_time1;
        cls.temperature=temperature1
        cls.humidity=humidity1
        cls.radiation=radiation1;
        cls.co2=co21
        cls.wind_direction=wind_direction1
        cls.wind_speed=wind_speed1
        cls.rain=rain1
        cls.atmosphere=atmosphere1
    @classmethod    
    def getupdate_time(cls):
        return cls.update_time
    @classmethod
    def getTemperature(cls):
        return cls.temperature
    @classmethod
    def gethumidity(cls):
        return cls.humidity
    @classmethod
    def getradiation(cls):
        return cls.radiation
    @classmethod
    def getCo2(cls):
        return cls.co2
    @classmethod
    def getwind_direction(cls):
        return cls.wind_direction
    @classmethod
    def getWind_speed(cls):
        return cls.wind_speed
    @classmethod
    def getRain(cls):
        return cls.rain
    @classmethod
    def getatmosphere(cls):
        return cls.atmosphere
    @classmethod
    def setupdate_time(cls,update_time):
        cls.update_time=update_time;
    @classmethod
    def sethumidity(cls,humidity):
        cls.humidity=humidity;
    @classmethod
    def setradiation(cls,radiation):
        cls.radiation=radiation;
    @classmethod
    def setco2(cls,co2):
        cls.co2=co2;
    @classmethod
    def setwind_direction(cls,wind_direction):
        cls.wind_direction=wind_direction;
    @classmethod
    def setwind_speed(cls,wind_speed):
        cls.wind_speed=wind_speed;
    @classmethod
    def setrain(cls,rain):
        cls.rain=rain;
    @classmethod
    def setatmosphere(cls,atmosphere):
        cls.atmosphere=atmosphere;  
    @classmethod
    def settemperature(cls,value):
        cls.temperature=value;   
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
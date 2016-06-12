
'''
Created on 2016年6月2日

@author: Zxh

upDatetime
temperature
humidity
par
co2
wind_dir
wind_speed
rain
pressure

'''
from builtins import classmethod
from pip._vendor.requests.models import json

class DailyWeather:
    upDatetime="2016/06/01"
    temperature=22
    humidity=80
    par=123
    co2='500'
    wind_dir='东南风'
    wind_speed='4'
    rain='1'
    pressure='1000'
    @classmethod
    def setDailyWeather(cls,upDatetime1,temperature1,humidity1,par1,co21,wind_dir1,wind_speed1,rain1,pressure1):
        cls.upDatetime=upDatetime1;
        cls.temperature=temperature1
        cls.humidity=humidity1
        cls.par=par1;
        cls.co2=co21
        cls.wind_dir=wind_dir1
        cls.wind_speed=wind_speed1
        cls.rain=rain1
        cls.pressure=pressure1
    @classmethod    
    def getUpDatetime(cls):
        return cls.upDatetime
    @classmethod
    def getTemperature(cls):
        return cls.temperature
    @classmethod
    def getHumidity(cls):
        return cls.humidity
    @classmethod
    def getPar(cls):
        return cls.par
    @classmethod
    def getCo2(cls):
        return cls.co2
    @classmethod
    def getWind_dir(cls):
        return cls.wind_dir
    @classmethod
    def getWind_speed(cls):
        return cls.wind_speed
    @classmethod
    def getRain(cls):
        return cls.rain
    @classmethod
    def getPressure(cls):
        return cls.pressure
    @classmethod
    def setupDatetime(cls,upDatetime):
        cls.upDatetime=upDatetime;
    @classmethod
    def sethumidity(cls,humidity):
        cls.humidity=humidity;
    @classmethod
    def setpar(cls,par):
        cls.par=par;
    @classmethod
    def setco2(cls,co2):
        cls.co2=co2;
    @classmethod
    def setwind_dir(cls,wind_dir):
        cls.wind_dir=wind_dir;
    @classmethod
    def setwind_speed(cls,wind_speed):
        cls.wind_speed=wind_speed;
    @classmethod
    def setrain(cls,rain):
        cls.rain=rain;
    @classmethod
    def setpressure(cls,pressure):
        cls.pressure=pressure;    
    @classmethod
    def classtoJson(cls):
        hjson='{\n"out_weather":\n{'+'\n"upDatetime":"'+cls.upDatetime+'",\n"temperature":"'+cls.temperature+'",\n"humidity":"'+cls.humidity+'",\n"par":"'+cls.par+'",\n"co2":"'+cls.co2+'",\n"wind_dir":"'+cls.wind_dir+'",\n"wind_speed":"'+cls.wind_speed+'",\n"rain":"'+cls.rain+'",\n"pressure":"'+cls.pressure+'"\n}\n}'
        return json.dumps(hjson)



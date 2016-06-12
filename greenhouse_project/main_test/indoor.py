
import time
class Indoor(object):
    '''the object of indoor climate'''
    updateTime="2016/06/06 12:12"
    temperature = 0
    humidity = 0
    radiation = 0
    co2 = 0

    def __init__(self):
        self.updateTime=time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time()))

    def set_outdoor(self, temperature, humidity, radiation, co2):
        self.temperature = temperature
        self.humidity = humidity
        self.radiation = radiation
        self.co2 = co2

    def set_updateTime(self):
        self.updateTime=time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time()))
        
    def set_temperature(self, temperature):
        self.temperature = temperature

    def set_humidity(self, hum):
        self.humidity = hum

    def set_radiation(self, rad):
        self.radiation = rad

    def set_co2(self, co2):
        self.co2 = co2

    def get_temperature(self):
        return self.temperature

    def get_humidity(self):
        return self.humidity

    def get_radiation(self):
        return self.radiation

    def get_co2(self):
        return self.co2
    def classToJson(self,a):
        return '''{"indoor": {"%s": {"updatetime": "%s","temperature": "%s","relative_humidity": "%s","radiation": "%s","co2": "%s"}}}''' \
           % (a,self.updateTime, self.temperature, self.humidity, self.radiation, self.co2)

class Indoor:
    '''the object of indoor climate'''

    temperature = 0
    humidity = 0
    radiation = 0
    co2 = 0

    def __init__(self):
        pass

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

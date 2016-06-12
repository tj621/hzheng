'''
Created on 2016年6月11日

@author: Zxh
'''

class Control_state(object):
    '''
    classdocs
    '''
    def __init__(self):
        pass
    def set_Control_state(self, roof_vent_south, roof_vent_north, side_vent, shade_screen_out, shade_screen_in, thermal_screen, water_pump, fogging, hearting, co2, lighting_1, lighting_2, irrigation):
        self.roof_vent_south = roof_vent_south
        self.roof_vent_north = roof_vent_north
        self.side_vent = side_vent
        self.shade_screen_out = shade_screen_out
        self.shade_screen_in = shade_screen_in
        self.thermal_screen = thermal_screen
        self.water_pump = water_pump
        self.fogging = fogging
        self.hearting = hearting
        self.co2 = co2
        self.lighting_1 = lighting_1
        self.lighting_2 = lighting_2
        self.irrigation = irrigation


    def get_roof_vent_south(self):
        return self.__roof_vent_south


    def get_roof_vent_north(self):
        return self.__roof_vent_north


    def get_side_vent(self):
        return self.__side_vent


    def get_shade_screen_out(self):
        return self.__shade_screen_out


    def get_shade_screen_in(self):
        return self.__shade_screen_in


    def get_thermal_screen(self):
        return self.__thermal_screen


    def get_water_pump(self):
        return self.__water_pump


    def get_fogging(self):
        return self.__fogging


    def get_hearting(self):
        return self.__hearting


    def get_co_2(self):
        return self.__co2


    def get_lighting_1(self):
        return self.__lighting_1


    def get_lighting_2(self):
        return self.__lighting_2


    def get_irrigation(self):
        return self.__irrigation


    def set_roof_vent_south(self, value):
        self.__roof_vent_south = value


    def set_roof_vent_north(self, value):
        self.__roof_vent_north = value


    def set_side_vent(self, value):
        self.__side_vent = value


    def set_shade_screen_out(self, value):
        self.__shade_screen_out = value


    def set_shade_screen_in(self, value):
        self.__shade_screen_in = value


    def set_thermal_screen(self, value):
        self.__thermal_screen = value


    def set_water_pump(self, value):
        self.__water_pump = value


    def set_fogging(self, value):
        self.__fogging = value


    def set_hearting(self, value):
        self.__hearting = value


    def set_co_2(self, value):
        self.__co2 = value


    def set_lighting_1(self, value):
        self.__lighting_1 = value


    def set_lighting_2(self, value):
        self.__lighting_2 = value


    def set_irrigation(self, value):
        self.__irrigation = value

    roof_vent_south="on";
    roof_vent_north="on";
    side_vent="on";
    shade_screen_out="off";
    shade_screen_in="off";
    thermal_screen="off"
    
    water_pump="off"
    fogging="off"
    hearting="on"
    co2="off"
    lighting_1="off"
    lighting_2="off"
    irrigation="pff"
    roof_vent_south = property(get_roof_vent_south, set_roof_vent_south, None, None)
    roof_vent_north = property(get_roof_vent_north, set_roof_vent_north, None, None)
    side_vent = property(get_side_vent, set_side_vent, None, None)
    shade_screen_out = property(get_shade_screen_out, set_shade_screen_out, None, None)
    shade_screen_in = property(get_shade_screen_in, set_shade_screen_in, None, None)
    thermal_screen = property(get_thermal_screen, set_thermal_screen, None, None)
    water_pump = property(get_water_pump, set_water_pump, None, None)
    fogging = property(get_fogging, set_fogging, None, None)
    hearting = property(get_hearting, set_hearting, None, None)
    co2 = property(get_co_2, set_co_2, None, None)
    lighting_1 = property(get_lighting_1, set_lighting_1, None, None)
    lighting_2 = property(get_lighting_2, set_lighting_2, None, None)
    irrigation = property(get_irrigation, set_irrigation, None, None)
    
    
        
    
    
'''
Created on 2016年6月11日

@author: Zxh
'''

class Control_state(object):
    '''
    classdocs
    '''
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
        
    def __init__(self):
        '''
        Constructor
        '''

    def get_hearting(self):
        return self.__hearting


    def get_irrigation(self):
        return self.__irrigation


    def set_hearting(self, value):
        self.__hearting = value


    def set_irrigation(self, value):
        self.__irrigation = value
         
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


    def get_water_pad(self):
        return self.__water_pad


    def get_water_pump(self):
        return self.__water_pump


    def get_fogging(self):
        return self.__fogging


    def get_co_2(self):
        return self.__co2


    def get_lighting_1(self):
        return self.__lighting_1


    def get_lighting_2(self):
        return self.__lighting_2


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


    def set_water_pad(self, value):
        self.__water_pad = value


    def set_water_pump(self, value):
        self.__water_pump = value


    def set_fogging(self, value):
        self.__fogging = value


    def set_co_2(self, value):
        self.__co2 = value


    def set_lighting_1(self, value):
        self.__lighting_1 = value


    def set_lighting_2(self, value):
        self.__lighting_2 = value

    roof_vent_south = property(get_roof_vent_south, set_roof_vent_south, None, None)
    roof_vent_north = property(get_roof_vent_north, set_roof_vent_north, None, None)
    side_vent = property(get_side_vent, set_side_vent, None, None)
    shade_screen_out = property(get_shade_screen_out, set_shade_screen_out, None, None)
    shade_screen_in = property(get_shade_screen_in, set_shade_screen_in, None, None)
    thermal_screen = property(get_thermal_screen, set_thermal_screen, None, None)
    water_pad = property(get_water_pad, set_water_pad, None, None)
    water_pump = property(get_water_pump, set_water_pump, None, None)
    fogging = property(get_fogging, set_fogging, None, None)
    co2 = property(get_co_2, set_co_2, None, None)
    lighting_1 = property(get_lighting_1, set_lighting_1, None, None)
    lighting_2 = property(get_lighting_2, set_lighting_2, None, None)
    
    def classtoJson(self):
        pass
    hearting = property(get_hearting, set_hearting, None, None)
    irrigation = property(get_irrigation, set_irrigation, None, None)
        
    
    
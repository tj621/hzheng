'''
Created on 2016年6月11日

@author: Zxh
'''

import time
class Control_state:
    '''
    classdocs
    '''
    updateTime="2016/06/06 12:12"
    
    roof_vent_south="on";
    roof_vent_north="on";
    side_vent="on";
    shade_screen_out="off";
    shade_screen_in="off";
    thermal_screen="off"
    
    cooling_pad="off"
    fogging="off"
    hearting="on"
    co2="off"
    lighting_1="off"
    lighting_2="off"
    irrigation="off"
    
    tril_control=("roof_vent_south",'roof_vent_north','side_vent','shade_screen_out','shade_screen_in','thermal_screen')
    bi_control=('cooling_pad','fogging','hearting','co2','lighting_1','lighting_2','irrigation')
    tril_state=("on","off","stop")
    bi_state=("on","off")
    
    def __init__(self):
        self.updateTime=time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time()))
    
    def set_updateTime(self):
        self.updateTime=time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time()))
    
    def set_Control_state(self, roof_vent_south, roof_vent_north, side_vent, shade_screen_out, shade_screen_in, thermal_screen, cooling_pad, fogging, hearting, co2, lighting_1, lighting_2, irrigation):
        self.roof_vent_south = roof_vent_south
        self.roof_vent_north = roof_vent_north
        self.side_vent = side_vent
        self.shade_screen_out = shade_screen_out
        self.shade_screen_in = shade_screen_in
        self.thermal_screen = thermal_screen
        self.cooling_pad = cooling_pad
        self.fogging = fogging
        self.hearting = hearting
        self.co2 = co2
        self.lighting_1 = lighting_1
        self.lighting_2 = lighting_2
        self.irrigation = irrigation


    def get_roof_vent_south(self):
        return self.roof_vent_south


    def get_roof_vent_north(self):
        return self.roof_vent_north


    def get_side_vent(self):
        return self.side_vent


    def get_shade_screen_out(self):
        return self.shade_screen_out


    def get_shade_screen_in(self):
        return self.shade_screen_in


    def get_thermal_screen(self):
        return self.thermal_screen


    def get_cooling_pad(self):
        return self.cooling_pad


    def get_fogging(self):
        return self.fogging


    def get_hearting(self):
        return self.hearting


    def get_co_2(self):
        return self.co2


    def get_lighting_1(self):
        return self.lighting_1


    def get_lighting_2(self):
        return self.lighting_2


    def get_irrigation(self):
        return self.irrigation


    def set_roof_vent_south(self, value):
        self.roof_vent_south = value


    def set_roof_vent_north(self, value):
        self.roof_vent_north = value


    def set_side_vent(self, value):
        self.side_vent = value


    def set_shade_screen_out(self, value):
        self.shade_screen_out = value


    def set_shade_screen_in(self, value):
        self.shade_screen_in = value


    def set_thermal_screen(self, value):
        self.thermal_screen = value


    def set_cooling_pad(self, value):
        self.cooling_pad = value


    def set_fogging(self, value):
        self.fogging = value


    def set_hearting(self, value):
        self.hearting = value


    def set_co_2(self, value):
        self.co2 = value


    def set_lighting_1(self, value):
        self.lighting_1 = value


    def set_lighting_2(self, value):
        self.lighting_2 = value


    def set_irrigation(self, value):
        self.irrigation = value
     
    def clssToJson(self):
        return ''' 
        {
        "actuator": {
            "updateTime="%s"
            "tri_state": {
                "roof_vent_south": "%s",
                "roof_vent_north": "%s",
                "side_vent": "%s",
                "shade_screen_out": "%s",
                "shade_screen_in": "%s",
                "thermal_screen": "%s",
                           },
            "bi_state": {
                "cooling_pad": "%s",
                "fogging": "%s",
                "heating": "%s",
                "co2": "%s",
                "lighting_1": "%s",
                "lighting_2": "%s",
                "irrigation": "%s"
                        }
                    }
        }'''   \
        % (self.updateTime,self.roof_vent_south,self.roof_vent_south,self.side_vent,self.shade_screen_out,self.shade_screen_in,
           self.thermal_screen,self.cooling_pad,self.fogging,self.hearting,self.co2,self.lighting_1,self.lighting_2,self.irrigation)

# test     
# a=Control_state()
# print(a.get_co_2())     
# print(a.clssToJson())
     
    
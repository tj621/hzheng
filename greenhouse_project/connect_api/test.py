'''
Created on 2016年6月11日

@author: Zxh
'''
from connect_api.control_state import Control_state
a=Control_state();
a.set_co_2("value")
print(a.get_co_2())
print(a)
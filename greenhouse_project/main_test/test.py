'''
Created on 2016年6月15日

@author: Zxh
'''
import json
from main_test.control_state import Control_state

data='''{"lighting_2": "on","shade_screen_out":"on"}'''

print(data)
control=Control_state()
def test():
    dataObj=json.loads(data)
    keys=dataObj.keys()
    response="{"
    for key in keys:
        value=dataObj.get(key)
        if key in Control_state.tril_control:
            setattr(control,key, value)
            print(key,getattr(control,key))
            response+='''"%s":"%s",''' %(key,value)
        if key in Control_state.bi_control:
            setattr(control,key,value)
            print(key,getattr(control,key))
            response+='''"%s":"%s",''' %(key,value)
    response+="}"
    print(response)
# print(control.clssToJson())
test()
print(control.clssToJson())
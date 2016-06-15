'''
Created on 2016年6月14日

@author: Zxh
'''
import serial
from time import sleep

global serialport,send_data,recv_data
get_state=""
serialport = serial.Serial("com2",9600,timeout=1)
data='dd'

def send_control(send_data):
    serialport.write(send_data.encode(encoding='utf_8', errors='strict'))
def recv_state():
    serialport.write(get_state.encode(encoding='utf_8', errors='strict'))
    recv_data=serialport.readall().decode(encoding='utf_8', errors='strict')
    if recv_data=='':
        print('send message error')
        return 'send message error'
    else:
        return recv_data

while True:
    print(recv_state())
    send_data='hello'
    sleep(3)
    send_control(send_data)


'''
Created on 2016年6月7日

@author: Zxh
'''
  
from socketserver import TCPServer as TCP, StreamRequestHandler as SRH  
from time import ctime  
  
  
HOST = '192.167.1.103'  
PORT = 60000  
BUFSIZE=1024
ADDR = (HOST, PORT)  
  
class MyRequestHandler(SRH):  
    def handle(self):  
        print('...connected from:', self.client_address)  
        print(self.rfile.readline())
        self.wfile.write(('[%s] %s' %(ctime(), self.rfile.readline().decode())).encode())  
        
tcpServ = TCP(ADDR, MyRequestHandler)  
print('waiting for connection...')  
tcpServ.serve_forever()  
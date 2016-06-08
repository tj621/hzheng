'''
Created on 2016年6月7日

@author: Zxh
'''
# Echo server program  
from socket import *  
from time import ctime  
  
HOST = '192.167.1.103'                 # Symbolic name meaning all available interfaces  
PORT = 60000              # Arbitrary non-privileged port  
BUFSIZE = 1024  
ADDR = (HOST, PORT)  
  
tcpSerSock = socket(AF_INET, SOCK_STREAM)  
tcpSerSock.bind(ADDR)  
tcpSerSock.listen(5)  
  
while True:  
    print('waiting for connection...')  
    tcpCliSock, addr = tcpSerSock.accept()  
    print('...connected from:', addr)  
  
    while True:  
        data = tcpCliSock.recv(BUFSIZE).decode()  
        if not data:  
            break  
        tcpCliSock.send(('[%s] %s' % (ctime(), data)).encode()) 
        print(data) 
  
    tcpCliSock.close()  
tcpSerSock.close()  

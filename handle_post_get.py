'''
Created on 2016年6月7日

@author: Zxh
'''
#!coding=UTF-8      
from http.server import HTTPServer,BaseHTTPRequestHandler       
import io,shutil,urllib       
import cgi
    
class MyHttpHandler(BaseHTTPRequestHandler):      
    name="World" 
    def do_GET(self):        
        if '?' in self.path:#如果带有参数       
            self.queryString=urllib.parse.unquote(self.path.split('?',1)[1])       
            #name=str(bytes(params['name'][0],'GBK'),'utf-8')       
            params=urllib.parse.parse_qs(self.queryString)       
            print(params)       
            name=params["name"][0] if "name" in params else None       
        r_str="Hello "+name 
        if name=="hzheng":
            r_str="weather"
        enc="UTF-8"      
        encoded = ''.join(r_str).encode(enc)       
        f = io.BytesIO()       
        f.write(encoded)       
        f.seek(0)       
        self.send_response(200)       
        self.send_header("Content-type", "text/html; charset=%s" % enc)       
        self.send_header("Content-Length", str(len(encoded)))       
        self.end_headers()       
        shutil.copyfileobj(f,self.wfile)       
    def do_POST(self):       
        s=str(self.rfile.readline(),'UTF-8')#先解码    
#         form = cgi.FieldStorage()   
#         name=form.getvalue('name')
#         self.write(name)   无效
#         print(urllib.parse.parse_qs(urllib.parse.unquote(s)))#解释参数       
        self.send_response(200)#URL跳转       
        self.send_header("Location", "/?"+s)       
        self.end_headers()       
def start_server(port):  
    http_server = HTTPServer(('[IP]', int(port)), MyHttpHandler)  
    http_server.serve_forever()
     
httpd=HTTPServer(('',800),MyHttpHandler)       
print("Server started on 127.0.0.1,port 800.....")       
httpd.serve_forever()   
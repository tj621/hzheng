# -*- coding: utf-8 -*-
import urllib.request,json,sys
response = urllib.request.urlopen("https://api.heweather.com/x3/weather?city=jiading&key=8924d0a789dd4e348982cfe7f721267c")
weatherJson=json.JSONDecoder().decode(response.read())
print(weatherJson)
input("\n\ni呵呵呵")

from out_weather.weather_dao import DailyWeather
import os
import sqlite3
from out_weather.weatherFromApi import getWeatherData , getWeatherJson
from out_weather.weather_sqlite import init_db, add_out_weather
dw=getWeatherJson()
print(dw.doit())
init_db()
add_out_weather(dw)
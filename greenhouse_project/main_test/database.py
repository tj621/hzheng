'''
Created on 2016年6月14日

@author: Zxh
'''
from flask import Flask, request, session, g, redirect, url_for, \
     abort, render_template, flash
import sqlite3
import os
from main_test.outdoor import Outdoor
from contextlib import closing

app=Flask(__name__)

app.config.update(dict(
    DATABASE=os.path.join(app.root_path, 'greenhouse.db'),
    DEBUG=True,
    SECRET_KEY='development key',
    USERNAME='admin',
    PASSWORD='default'
    ))

def connect_db():
    """Connects to the specific database."""
    rv = sqlite3.connect(app.config['DATABASE'])
    rv.row_factory = sqlite3.Row
    return rv

def init_db():
    with app.app_context():
        db = get_db()
        with app.open_resource('schema.sql', mode='r') as f:
            db.cursor().executescript(f.read())
        db.commit()

def get_db():
    if not hasattr(g, 'sqlite_db'):
        g.sqlite_db=connect_db()
    return g.sqlite_db

def close_db():
    if hasattr(g, 'sqlite_db'):
        g.sqlite_db.close()    


    
#test
# init_db()
# out=Outdoor()
# with app.app_context():
#     db=get_db()
#     db.execute('''insert into outdoor(update_time,temperature,humidity,radiation,co2,wind_direction,wind_speed,rain_snow,atmosphere)\
#                    values(?,?,?,?,?,?,?,?,?)''', [out.update_time,out.temperature,out.humidity,out.radiation,out.co2,out.wind_direction,\
#                                                 out.wind_speed,out.rain,out.atmosphere])
#     db.commit()
# print(out.classtoJson())   
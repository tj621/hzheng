from flask import Flask,request
 
from main_test.indoor import Indoor
from main_test.outdoor import Outdoor
from main_test.scheduler import Scheduler
from main_test.control_state import Control_state
from main_test.database import init_db, get_db, close_db
import json


app = Flask(__name__)
node0 =Indoor()
outdoor=Outdoor()
control=Control_state()

def save_indoor(node,Indoor):
    with app.app_context():
        db=get_db()
        db.execute('insert into indoor(node_number,update_time,temperature,humidity,radiation,co2) values(?,?,?,?,?,?)',
                    [node,Indoor.updateTime,Indoor.temperature,Indoor.humidity,Indoor.radiation,Indoor.co2])
        db.commit()
    print('%s indoor save successed',node)
def save_outdoor(Outdoor):
    with app.app_context():
        db=get_db()
        db.execute('insert into outdoor(update_time,temperature,humidity,radiation,co2,wind_direction,wind_speed,rain_snow,atmosphere)\
                   values(?,?,?,?,?,?,?,?,?)', [Outdoor.update_time,Outdoor.temperature,Outdoor.humidity,Outdoor.radiation,Outdoor.co2,Outdoor.wind_direction,\
                                                Outdoor.wind_speed,Outdoor.rain,Outdoor.atmosphere])
        db.commit()
    print('outdoor save successed')

def save_control(Control_state):
    with app.app_context():
        db=get_db()
        db.execute('insert into control_state(update_time,roof_vent_south,roof_vent_north,side_vent,shade_screen_out,shade_screen_in,thermal_screen,\
        cooling_pad,fogging,hearting,co2,lighting_1,lighting_2,irrigation) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)',
        [Control_state.updateTime,Control_state.roof_vent_south,Control_state.roof_vent_north,Control_state.side_vent,Control_state.shade_screen_out,Control_state.shade_screen_in,\
         Control_state.thermal_screen,Control_state.cooling_pad,Control_state.fogging,Control_state.hearting,Control_state.co2,Control_state.lighting_1,Control_state.lighting_2,Control_state.irrigation])
        db.commit()
        print('control save successed')

def get_indoor():
#     node0.set_temperature(20.0)
#     node0.set_humidity(80.0)
#     node0.set_radiation(8000)
#     node0.set_co2(500)
    save_indoor('node0',node0)
    print('indoor')

def get_outdoor():
    outdoor.getWeatherFromApi()
    save_outdoor(outdoor)
    print('outdoor')
   
def get_control():
    save_control(control)
    print('control')
    
@app.route('/')
def index():
    return '<h1>Hello World!</h1>'

@app.route('/indoor')
def response_indoor():
    node0.set_updateTime()
    return node0.classToJson('node0')

@app.route('/outdoor')
def response_outdoor():
    outdoor.getupdate_time()
    return outdoor.classtoJson()


@app.route('/control',methods=['GET','POST'])
def response_control_state():
    control.set_updateTime()
    if request.method =='POST':
        data=request.data.decode()
        print(data)
        dataObj=json.loads(data)
        keys=dataObj.keys()
        response="{"
        response+='''"updateTime":"%s",''' % (control.updateTime)
        for key in keys:
            value=dataObj.get(key)
            if key in Control_state.tril_control:
                if value in Control_state.tril_state:
                    setattr(control,key, value)
                    print(key,getattr(control,key))
                    response+='''"%s":"%s",''' %(key,value)
                else:
                    print("command wrong")
                    return "command wrong"
            if key in Control_state.bi_control:
                if value in Control_state.bi_state:
                    setattr(control,key,value)
                    print(key,getattr(control,key))
                    response+='''"%s":"%s",''' %(key,value)
                else:
                    print("command wrong")
                    return "command wrong"     
        response+="}"
        return response
    else:
        return control.clssToJson()

@app.route('/hi')
def change():
    node0.set_temperature(30.0)
    return '<h1>set temp from 20 to 30</h1>'

if __name__ == '__main__':
    init_db()
#     scheduler1 = Scheduler(2, get_outdoor)
#     scheduler2 = Scheduler(3, get_indoor)
#     scheduler1.start()
#     scheduler2.start()
    app.run('0.0.0.0', '8020')
    close_db()

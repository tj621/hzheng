

from flask import Flask
 
from main_test.indoor import Indoor
from main_test.outdoor import Outdoor
from main_test.scheduler import Scheduler
from flask.globals import request
from main_test.control_state import Control_state



app = Flask(__name__)

node0 =Indoor()
print ("temperature", node0.temperature)
print ("humidity", node0.humidity)
print ("radiation", node0.radiation)
print ("co2", node0.co2)
node0.set_temperature(20.0)
node0.set_humidity(80.0)
node0.set_radiation(8000)
node0.set_co2(500)
print ("temperature", node0.temperature)
print ("humidity", node0.humidity)
print ("radiation", node0.radiation)
print ("co2", node0.co2)

outdoor=Outdoor()
control=Control_state()

def get_indoor():
    print('indoor')

def get_outdoor():
#     outdoor.getWeatherFromApi()
    print('outdoor')
   
    
@app.route('/')
def index():
    return '<h1>Hello World!</h1>'

@app.route('/indoor')
def response_indoor():
    return node0.classToJson('node0')

@app.route('/outdoor')
def response_outdoor():
    return outdoor.classtoJson()


@app.route('/control',methods=['GET', 'POST'])
def get_controlstate():
    if request.methods =='POST':
        return request.json()
    else:
        return control.clssToJson()

@app.route('/hi')
def change():
    node0.set_temperature(30.0)
    return '<h1>set temp from 20 to 30</h1>'

if __name__ == '__main__':
    scheduler1 = Scheduler(2, get_outdoor)
    scheduler2 = Scheduler(3, get_indoor)
    scheduler1.start()
    scheduler2.start()
    app.run('0.0.0.0', '8020')
#     scheduler.stop()

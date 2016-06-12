

from flask import Flask
from flask import abort
from flask import redirect

from main_test.indoor import Indoor
from main_test.outdoor import Outdoor
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

@app.route('/')
def index():
    return '<h1>Hello World!</h1>'

@app.route('/indoor')
def get_indoor():
    return node0.classToJson('node0')

@app.route('/outdoor')
def get_outdoor():
    outdoor.getWeatherFromApi()
    return outdoor.classtoJson()
@app.route('/control')
def get_controlstate():
    pass
if __name__ == '__main__':
    app.run('127.0.0.1', '8020')

from indoor import Indoor

from flask import Flask
from flask import abort
from flask import redirect

import time

app = Flask(__name__)

node0 = Indoor()
print "temperature", node0.temperature
print "humidity", node0.humidity
print "radiation", node0.radiation
print "co2", node0.co2
node0.set_temperature(20.0)
node0.set_humidity(80.0)
node0.set_radiation(8000)
node0.set_co2(500)
print "temperature", node0.temperature
print "humidity", node0.humidity
print "radiation", node0.radiation
print "co2", node0.co2


def get_now_time():
    return time.strftime("%Y-%m-%d %H:%M:%S", time.localtime(time.time()))


print get_now_time()


@app.route('/')
def index():
    return '<h1>Hello World!</h1>'


@app.route('/indoor')
def get_indoor():
    return '''{"indoor": {"node_0": {"updatetime": "%s",
    "temperature": "%s","relative_humidity": "%s",
    "radiation": "%s","co2": "%s"}}}''' \
           % (get_now_time(), node0.temperature, node0.humidity, node0.radiation, node0.co2)


if __name__ == '__main__':
    app.run('0.0.0.0', '8020')

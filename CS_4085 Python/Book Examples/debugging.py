import traceback
import logging
logging.basicConfig(filename = 'debuggingLogTest.txt', level=logging.DEBUG, format=' %(asctime)s - %(levelname)s - %(message)s')
logging.debug('Start of program')

# logging.basicConfig has different levels : DEBUG, INFO, WARNING, ERROR, CRITICAL based on
# which types of logs you want to be made aware of
#************************
"""
def boxPrint(symbol, width, height):
    if len(symbol) !=1:
        raise Exception('Symbol must be a single character string.')
    if width <=2:
        raise Exception('Width must be greater than 2.')
    if height <=2:
        raise Exception('Height must be greater than 2.')
    print(symbol * width)
    for i in range(height - 2):
        print(symbol + (' ' * (width - 2)) + symbol)
    print(symbol * width)

for sym, w, h in (('*', 4, 4), ('O', 20, 5), ('x', 1, 3), ('zz', 3, 3)):
    try:
        boxPrint(sym, w, h)
    except Exception as err:
        print('An exception happened: ' + str(err))
"""
# ************************
"""
def spam():
    bacon()
def bacon():
    raise Exception('This is the error message.')

spam()
"""

#*****************************
"""
try:
    raise Exception('This is the error message.')
except:
    errorFile = open('errorInfo.txt', 'w')
    errorFile.write(traceback.format_exc())
    errorFile.close()
    print('The traceback info was written to errorInfo.txt.')
"""
# ***************************
"""
#intersection of Market St and 2nd St - Mission St and 16th St
market_2nd = {'ns' : 'green', 'ew' : 'red'}
mission_16th = {'ns' : 'red', 'ew' : 'green'}

def switchLights(stoplight):
    for key in stoplight.keys():
        if stoplight[key] == 'green' :
            stoplight[key] = 'yellow'
        elif stoplight[key] == 'yellow' :
            stoplight[key] = 'red'
        elif stoplight[key] == 'red' :
            stoplight[key] = 'green'

    assert 'red' in stoplight.values(), 'Neither light is red! ' + str(stoplight)
    
# cars are going to crash
switchLights(market_2nd)
"""
#******************************

def factorial(n):
    logging.debug('Start of factorial(%s)' % (n))
    total = 1
    for i in range(n + 1):
        total *= i
        logging.debug('i is ' + str(i) + ', total is ' + str(total))
    logging.debug('End of factorial(%s)' % (n))
    return total

def correctFactorial(n):
    logging.debug('Start of factorial(%s)' % (n))
    total = 1
    for i in range(1, n + 1):
        total *= i
        logging.debug('i is ' + str(i) + ', total is ' + str(total))
    logging.debug('End of factorial(%s)' % (n))
    return total


print(factorial(5))
print(correctFactorial(5))
logging.debug('End of program')
# logging.disable(logging.CRITICAL)  - disables all logging messages CRITICAL and lower

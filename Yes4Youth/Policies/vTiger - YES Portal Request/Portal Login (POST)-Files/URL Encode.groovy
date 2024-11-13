import java.net.URLEncoder
import com.vordel.trace.Trace

def invoke(message){

def sessionToken = message.get("y4y.jwt.sessionToken")

def portalKey = message.get("portalKey")
def deviceToken = message.get("deviceToken")
def username = message.get("userName")
def password = message.get("password")
Trace.info('~~~~~~' + portalKey)

def allParams = [
    'operation'   : 'loginPortal',
    'sessionName' : sessionToken,
    'deviceToken' : deviceToken,
    'portal_key'  : portalKey,
    'username'    : username,
    'password'    : password
]

def queryString = allParams.collect { key, value ->
    key + "=" + URLEncoder.encode(value, 'UTF-8')
}.join('&')


Trace.info('~~~~~~~~~~~~' + queryString)
message.put("queryString", queryString)

return true
}
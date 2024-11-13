import java.net.URLEncoder
import com.vordel.trace.Trace

def invoke(message){

def sessionToken = message.get("y4y.jwt.sessionToken")

def portalKey = message.get("portalKey")
Trace.info('~~~~~~' + portalKey)

def allParams = [
    'operation'   : 'getPortal',
    'portal_key'  : portalKey,
    'sessionName' : sessionToken
]

def queryString = allParams.collect { key, value ->
    key + "=" + URLEncoder.encode(value, 'UTF-8')
}.join('&')


Trace.info('~~~~~~~~~~~~' + queryString)
message.put("queryString", queryString)

return true
}
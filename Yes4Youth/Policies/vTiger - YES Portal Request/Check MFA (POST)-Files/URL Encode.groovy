import java.net.URLEncoder
import com.vordel.trace.Trace

def invoke(message){

def sessionToken = message.get("y4y.jwt.sessionToken")

def portalKey = message.get("portalKey")
def mfaToken = message.get("mfaToken")
def mfaCode = message.get("mfaCode")
def password = message.get("password")

def allParams = [
    'operation'   : 'postData',
    'sessionName' : sessionToken,
    'mfa_oken' : mfaToken,
    'mfa_code' : mfaCode,
    'method' : 'checkMFA',
    'portal_key'  : portalKey,
]

def queryString = allParams.collect { key, value ->
    key + "=" + URLEncoder.encode(value, 'UTF-8')
}.join('&')


Trace.info('~~~~~~~~~~~~' + queryString)
message.put("queryString", queryString)

return true
}
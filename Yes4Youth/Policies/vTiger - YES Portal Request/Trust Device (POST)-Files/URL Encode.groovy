import com.vordel.trace.Trace
import java.net.URLEncoder

def invoke (message) {
    
def sessionToken = message.get("y4y.jwt.sessionToken")

def portalKey = message.get("portalKey")
def mfaToken = message.get("mfaToken")
def mfaCode = message.get("mfaCode")
def userName = message.get("userName")
def contactId = message.get("contactId")

def allParams = ['operation': 'postData'] + ['sessionName': sessionToken] + ['method' : 'trustDevice'] + ['portal_key' : portalKey] + ['mfa_token' : mfaToken] + ['mfa_code' : mfaCode] + ['contactId' : contactId] + ['username' : userName] + ['trust_choice' : 'trust']

def queryString = allParams.collect { key, value ->
    key + "=" + URLEncoder.encode(value, 'UTF-8')
}.join('&')

message.put("queryString", queryString)

return true

}

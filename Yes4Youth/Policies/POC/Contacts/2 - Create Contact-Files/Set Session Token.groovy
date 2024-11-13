import com.vordel.trace.Trace

def invoke(com.vordel.dwe.http.HTTPMessage message) {
    
def jsonString = message.get("jwt.body")

def jsonSlurper = new groovy.json.JsonSlurper()
def jsonObject = jsonSlurper.parseText(jsonString)

def sessionToken = jsonObject.sessionToken
def subject = jsonObject.sub

message.put("sessionToken", sessionToken)
message.put("auth.axwayUser", subject)
    return true
}

import com.vordel.trace.Trace

def invoke(com.vordel.dwe.http.HTTPMessage message) {
    
def jsonString = message.get("jwt.body")

def jsonSlurper = new groovy.json.JsonSlurper()
def jsonObject = jsonSlurper.parseText(jsonString)

def sessionToken = jsonObject.sessionToken

message.put("sessionToken", sessionToken)

    return true
}

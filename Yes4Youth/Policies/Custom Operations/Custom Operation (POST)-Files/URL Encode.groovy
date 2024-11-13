import com.vordel.trace.Trace
import java.net.URLEncoder
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import com.vordel.circuit.Message
import com.vordel.circuit.CircuitAbortException
import com.vordel.dwe.http.HTTPMessage
import com.vordel.mime.Body;
import com.vordel.mime.HeaderSet;

def invoke(message) {
    
def sessionToken = message.get("y4y.jwt.sessionToken")

def jsonString = message.get("params.body").toString()

def jsonSlurper = new JsonSlurper()

def jsonObject = jsonSlurper.parseText(jsonString)

def allParams = ['operation': jsonObject.operation] + jsonObject.params + ['sessionName': sessionToken]

def queryString = allParams.collect { key, value ->
    key + "=" + URLEncoder.encode(value, 'UTF-8')
}.join('&')

message.put("queryString", queryString)

return true

}

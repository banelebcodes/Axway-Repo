import com.vordel.trace.Trace
import java.net.URLEncoder
import groovy.json.JsonOutput
import com.vordel.circuit.Message
import com.vordel.circuit.CircuitAbortException
import com.vordel.dwe.http.HTTPMessage
import com.vordel.mime.Body;
import com.vordel.mime.HeaderSet;

def invoke(message) {
    
def sessionToken = message.get("y4y.jwt.sessionToken")
def elementType = message.get("elementType")
def operation = message.get("operation")

if(operation != "delete") {
    def jsonString = message.get("params.body").toString()
def encodedJsonString = URLEncoder.encode(jsonString, "UTF-8")

def Map<String, String> bodyParameters = [
    operation: operation,
    sessionName: sessionToken,
    elementType: elementType,
    element: encodedJsonString
]

StringBuilder requestBody = new StringBuilder()
        bodyParameters.each { key, value ->
            if (requestBody.length() > 0) {
                requestBody.append('&')
            }
            requestBody.append(key)
            requestBody.append('=')
            requestBody.append(value)
        }

message.put('vTiger.body', requestBody.toString())

}else {
    def id = message.get("element.id")
def Map<String, String> bodyParameters = [
    operation: operation,
    sessionName: sessionToken,
    elementType: elementType,
   iId: id,
] 

StringBuilder requestBody = new StringBuilder()
        bodyParameters.each { key, value ->
            if (requestBody.length() > 0) {
                requestBody.append('&')
            }
            requestBody.append(key)
            requestBody.append('=')
            requestBody.append(value)
        }

message.put('vTiger.body', requestBody.toString())
   
}




//Trace.info("Body", requestBody.toString())
//Trace.info("Headers",message.get('http.headers'))

    return true
}

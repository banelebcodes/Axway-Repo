import com.vordel.trace.Trace
import java.net.URLEncoder
import groovy.json.JsonOutput
import com.vordel.circuit.Message
import com.vordel.circuit.CircuitAbortException
import com.vordel.dwe.http.HTTPMessage
import com.vordel.mime.Body;
import com.vordel.mime.HeaderSet;

def invoke(message) {
    
def jsonString = message.get("params.body").toString()
def sessionToken = message.get("sessionToken")
def elementType = "Contacts"
def operation = "update"
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
//Trace.info("Body", requestBody.Body.toString())
//Trace.info("Headers",message.get('http.headers'))

    return true
}

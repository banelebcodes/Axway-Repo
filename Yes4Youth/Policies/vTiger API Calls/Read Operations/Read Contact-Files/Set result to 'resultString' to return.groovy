import java.security.MessageDigest
import com.vordel.trace.Trace
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

def invoke(message)
{


 // Retrieve attributes
    def result = message.get('result') 

        def firstElement = result[0]
        String resultString = JsonOutput.toJson(firstElement)
        message.put('resultString', resultString)

return true
}
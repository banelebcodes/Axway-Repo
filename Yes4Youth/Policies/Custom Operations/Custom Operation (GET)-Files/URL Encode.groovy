import com.vordel.trace.Trace
import java.net.URLEncoder

def invoke(message) {
    
def sessionToken = message.get("y4y.jwt.sessionToken")

def existingQueryString = message.get("http.querystring").toString()
Trace.info('~~~~' + existingQueryString)

def  updatedQueryString = existingQueryString + "&sessionName=" + URLEncoder.encode(sessionToken, "UTF-8")
Trace.info('~~~~~~~~' +  updatedQueryString)
message.put("queryString", updatedQueryString)

return true

}
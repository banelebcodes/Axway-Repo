import java.security.MessageDigest
import com.vordel.trace.Trace



def invoke(message)
{


// Retrieve attributes
def payload = message.get('payload') 

def token = payload.substring(7)

message.put('payload', token)

return true
}
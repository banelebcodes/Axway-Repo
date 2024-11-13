import java.security.MessageDigest
import com.vordel.trace.Trace
import groovy.json.JsonBuilder

def invoke(message)
{

def sessionToken = message.get('xentiger.jwt')

Trace.info("SessionToken: " + sessionToken);


def jwtPayload = [
    iss: "YourIssuer",
    exp: (System.currentTimeMillis() / 1000) + 3600, // Current time + 1 hour for expiration
    sub: "Xentiger", // or userId based on your requirement
    aud: "audience",
    username: "username",
    sessionToken: sessionToken,
    userId: "userId"
]
def jsonBuilder = new JsonBuilder(jwtPayload)
def jsonString = jsonBuilder.toString()

Trace.info("JWT Payload: " + jwtPayload);
message.put('jwtPayload', jsonString)

return true
}
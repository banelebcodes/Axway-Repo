import java.security.MessageDigest
import com.vordel.trace.Trace
import groovy.json.JsonBuilder

def invoke(message)
{

def username = message.get('vTiger.auth.user')
def sessionToken = message.get('vTiger.auth.session')
def userId = message.get('vTiger.auth.userId')
def compayId = message.get('user.companyId')
//def accessLevel = message.get('user')

Trace.info("Username: " + username);
Trace.info("SessionToken: " + sessionToken);
Trace.info("UserId: " + userId);



def jwtPayload = [
    iss: "YourIssuer",
    exp: (System.currentTimeMillis() / 1000) + 3600, // Current time + 1 hour for expiration
    sub: username, // or userId based on your requirement
    aud: "audience",
    username: username,
    sessionToken: sessionToken,
    userId: userId
]
def jsonBuilder = new JsonBuilder(jwtPayload)
def jsonString = jsonBuilder.toString()

Trace.info("JWT Payload: " + jwtPayload);
message.put('jwtPayload', jsonString)

return true
}
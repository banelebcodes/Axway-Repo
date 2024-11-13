import java.security.MessageDigest
import com.vordel.trace.Trace
import groovy.json.JsonBuilder

def invoke(message)
{

def username = message.get('vTiger.auth.user')
def sessionToken = message.get('vTiger.auth.session')
def userId = "UserId"
def compayId = "comapny"
def accessLevel = "user"

//Trace.info("Username: " + username);
Trace.info("SessionToken: " + sessionToken);
//Trace.info("UserId: " + userId);
//Trace.info("user:" + userGroup);

def exp =  (System.currentTimeMillis() / 1000) + 3600
message.put('expDate', exp)


def jwtPayload = [
    iss: "YourIssuer",
    exp: (System.currentTimeMillis() / 1000) + 3600, // Current time + 1 hour for expiration
    sub: message.get("authentication.subject.id"),
    aud: "audience",
    username: username,
    sessionToken: sessionToken,
    userId: "userId"
]
def jsonBuilder = new JsonBuilder(jwtPayload)
def jsonString = jsonBuilder.toString()

Trace.info("JWT Payload: " + jwtPayload);
message.put('jwtPayload', jsonString)

return true
}
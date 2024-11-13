import java.security.MessageDigest
import com.vordel.trace.Trace

// Function to perform MD5 hashing
def md5Hash(str) {
    MessageDigest md = MessageDigest.getInstance("MD5")
    byte[] digest = md.digest(str.getBytes("UTF-8"))
    digest.collect { String.format("%02x", it) }.join()
}

def invoke(message)
{


// Retrieve attributes
def string1 = message.get('vTiger.auth.token') // Replace 'attribute1' with your actual attribute name
def string2 = message.get('vTiger.auth.accessKey') // Replace 'attribute2' with your actual attribute name
Trace.info("Token:" + string1)
Trace.info("Token:" + string2)

// Combine the strings
def combinedString = string1 + string2

// Hash the combined string using MD5
def hashedValue = md5Hash(combinedString)

// Set the hashed value to a new attribute
message.put('vTiger.auth.hashedValue', hashedValue) // Replace 'hashedAttribute' with your desired attribute name
return true
}
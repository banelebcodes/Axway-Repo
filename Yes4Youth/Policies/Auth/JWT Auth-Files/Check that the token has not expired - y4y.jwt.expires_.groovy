import com.vordel.trace.Trace

def invoke(msg)         {            
	def expires = msg.get("y4y.jwt.expires").toLong()
	def now = new Date().getTime()/1000
	Trace.info("Expires=" + expires)
	Trace.info("Now    =" + now)
       if (expires < now) {
		return false
	}
	return true
}
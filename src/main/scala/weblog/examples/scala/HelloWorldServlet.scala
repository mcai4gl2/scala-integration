package weblog.examples.scala

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import java.io.OutputStream
import org.apache.log4j.Logger
import org.apache.commons.io.IOUtils
import HelloWorldServlet._

@Controller
class HelloWorldServlet {
  @RequestMapping(value = Array("/"), method = Array(RequestMethod.GET))
  def helloworld(request: HttpServletRequest, response: HttpServletResponse, outputStream: OutputStream) {
    log.info("helloworld is called")
    response.setStatus(HttpServletResponse.SC_OK)
    IOUtils.write("HELLO WORLD!", outputStream)
    outputStream.flush
    outputStream.close
  }
}

object HelloWorldServlet {
  private var log: Logger = Logger.getLogger(classOf[HelloWorldServlet])
}

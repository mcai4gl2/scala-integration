package weblog.examples.scala

import org.springframework.web.servlet.DispatcherServlet
import org.springframework.mock.web.{MockServletConfig, MockHttpServletResponse, MockHttpServletRequest}
import org.junit.{Assert, Test, After, Before}

class HelloWorldServletTest {
  private var dispatcherServlet : DispatcherServlet = _
  private var httpRequest : MockHttpServletRequest = _
  private var httpResponse : MockHttpServletResponse = _

  @Before
  def before() {
    val config = new MockServletConfig
    config.addInitParameter("contextConfigLocation", "classpath:servlet-context.xml")
    dispatcherServlet = new DispatcherServlet
    dispatcherServlet.init(config)

    httpRequest = new MockHttpServletRequest
    httpResponse = new MockHttpServletResponse
  }

  @After
  def after() {
    dispatcherServlet = null
    httpRequest = null
    httpResponse = null
  }

  @Test
  def testHelloWord() {
    httpRequest.setMethod("GET")
    httpRequest.setRequestURI("/")

    dispatcherServlet.service(httpRequest, httpResponse)

    val response = httpResponse.getContentAsString

    Assert.assertEquals("HELLO WORLD!", response)
  }
}


import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation extends Simulation {

	val httpProtocol = http
		.baseURL("http://192.168.5.2:8080")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.(t|o)tf""", """.*\.png"""), WhiteList())
		.acceptHeader("""text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8""")
		.acceptEncodingHeader("""gzip,deflate,sdch""")
		.acceptLanguageHeader("""de-DE,de;q=0.8,en-US;q=0.6,en;q=0.4""")
		.contentTypeHeader("""application/x-www-form-urlencoded; charset=UTF-8""")
		.doNotTrackHeader("""1""")
		.userAgentHeader("""Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.122 Safari/537.36""")

	val headers_8 = Map(
		"""Accept""" -> """application/json, text/javascript, */*; q=0.01""",
		"""Accept-Encoding""" -> """gzip,deflate""",
		"""Origin""" -> """http://notizblog.nierbeck.de""",
		"""X-Requested-With""" -> """XMLHttpRequest""")

	val headers_10 = Map(
		"""Accept-Encoding""" -> """gzip,deflate""",
		"""Cache-Control""" -> """max-age=0""",
		"""Origin""" -> """http://192.168.5.2:8080""")

    val uri1 = """http://192.168.5.2:8080/petclinic"""

	val scn = scenario("RecordedSimulation")
		// start
		.exec(http("request_0")
			.get("""/petclinic/"""))
		.pause(3)
		.exec(http("request_1")
			.get("""/petclinic/vets.html"""))
		.pause(8)
		.exec(http("request_2")
			.get("""/petclinic/owners/find.html"""))
		.pause(1)
		.exec(http("request_3")
			.get("""/petclinic/owners.html?lastName="""))
		.pause(2)
		.exec(http("request_4")
			.get("""/petclinic/owners/9.html"""))
		.pause(2)
		.exec(http("request_5")
			.get("""/petclinic/owners/find.html"""))
		.pause(1)
		.exec(http("request_6")
			.get("""/petclinic/owners.html?lastName="""))
		.pause(2)
		.exec(http("request_7")
			.get("""/petclinic/owners/5.html"""))
		.pause(1)
		.exec(http("request_9")
			.get("""/petclinic/owners/5/pets/6/visits/new"""))
		.pause(4)
		.exec(http("request_10")
			.post("""/petclinic/owners/5/pets/6/visits/new""")
			.headers(headers_10)
			.formParam("""date""", """2014/09/24""")
			.formParam("""description""", """Linda Douglas """)
			.formParam("""petId""", """6"""))
		.pause(7)
		// end

	setUp(scn.inject(atOnceUsers(100))).protocols(httpProtocol)
}
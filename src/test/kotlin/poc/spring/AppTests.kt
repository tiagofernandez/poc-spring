package poc.spring

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus

@SpringBootTest(
	classes = [App::class],
	webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
)
class AppTests {
	@Autowired
	lateinit var restTemplate: TestRestTemplate

	@Test
	fun testProbe() {
		val response = restTemplate.getForEntity("/probe", Map::class.java)
		assertEquals(HttpStatus.OK, response?.statusCode)
		assertEquals(emptyMap<String, Any>(), response.body)
	}
}

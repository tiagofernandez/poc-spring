package poc.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class App

fun main(args: Array<String>) {
	runApplication<App>(*args)
}

@RestController
class AppController {
	@GetMapping("/probe")
	fun probe() = emptyMap<String, Any>()
}

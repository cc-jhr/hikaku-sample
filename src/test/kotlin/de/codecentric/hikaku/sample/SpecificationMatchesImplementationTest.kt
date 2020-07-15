package de.codecentric.hikaku.sample

import de.codecentric.hikaku.Hikaku
import de.codecentric.hikaku.HikakuConfig
import de.codecentric.hikaku.converters.openapi.OpenApiConverter
import de.codecentric.hikaku.converters.spring.SpringConverter
import de.codecentric.hikaku.endpoints.HttpMethod.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import java.nio.file.Paths

@SpringBootTest
class SpecificationMatchesImplementationTest {

    @Autowired
    lateinit var springContext: ApplicationContext

    @Test
    fun `specification matches implementation`() {
        Hikaku(
                specification = OpenApiConverter(Paths.get(this::class.java.classLoader.getResource("openapi.json")!!.toURI())),
                implementation = SpringConverter(springContext),
                config = HikakuConfig(
                        filters = listOf(
                            SpringConverter.IGNORE_ERROR_ENDPOINT,
                            { endpoint -> endpoint.httpMethod == HEAD },
                            { endpoint -> endpoint.httpMethod == OPTIONS }
                        )
                )
        )
        .match()
    }
}

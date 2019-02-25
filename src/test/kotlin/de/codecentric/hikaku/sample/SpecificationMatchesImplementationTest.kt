package de.codecentric.hikaku.sample

import de.codecentric.hikaku.Hikaku
import de.codecentric.hikaku.HikakuConfig
import de.codecentric.hikaku.converter.openapi.OpenApiConverter
import de.codecentric.hikaku.converter.spring.SpringConverter
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
                specification = OpenApiConverter(Paths.get(this::class.java.classLoader.getResource("openapi.json").toURI())),
                implementation = SpringConverter(springContext),
                config = HikakuConfig(
                        ignorePaths = setOf(SpringConverter.IGNORE_ERROR_ENDPOINT),
                        ignoreHttpMethodOptions = true,
                        ignoreHttpMethodHead = true
                )
        )
        .match()
    }
}
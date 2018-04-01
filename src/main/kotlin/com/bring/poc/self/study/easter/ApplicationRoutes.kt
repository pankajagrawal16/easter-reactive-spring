package com.bring.poc.self.study.easter

import com.bring.poc.self.study.easter.handler.WelcomeHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.reactive.function.server.router

@Configuration
class ApplicationRoutes(private val welcome: WelcomeHandler) {

    @Bean
    fun apiRouter() = router {
        (accept(APPLICATION_JSON) and "/api").nest {
            "/easter".nest {
                GET("/", welcome::welcome)
                GET("/{name}", welcome::welcomeWithName)
            }
        }
    }
}
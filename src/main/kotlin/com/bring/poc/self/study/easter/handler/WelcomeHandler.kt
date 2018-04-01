package com.bring.poc.self.study.easter.handler

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_EMPTY
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono
import java.util.Random

@Component
class WelcomeHandler {

    fun welcome(req: ServerRequest): Mono<ServerResponse> {
        return ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(wish())
    }

    fun welcomeWithName(req: ServerRequest): Mono<ServerResponse> {
        return ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(wish(req.pathVariable("name")))
    }

    private fun wish(name: String = ""): Mono<Welcome> {
        return Mono.justOrEmpty( Welcome(Random().nextInt(), name) )
    }
}


data class Welcome(val id:Int,
    @JsonInclude(NON_EMPTY) val name: String)
package com.ouklich.demo.thegateway.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Profile("oauth")
@RestController
class GreetingsController {

    @GetMapping("/hello")
    Mono<String> hello() {
        return Mono.just("Hello from the gateway!");
    }

    @GetMapping("/secured")
    Mono<String> secured() {
        return Mono.just("Hello from the gateway secured resource!");
    }
}

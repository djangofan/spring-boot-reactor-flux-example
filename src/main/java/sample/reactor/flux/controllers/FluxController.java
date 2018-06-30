package sample.reactor.flux.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
public class FluxController {

    public FluxController() {
    }

    @GetMapping("/features")
    Flux<String> list() {
        return Flux.just("Features 1", "Features 2", "Features 3");
    }

    @GetMapping("/features/{id}")
    Mono<String> findById(@PathVariable String id) {
        return Mono.just("Features " + id);
    }

    @GetMapping("/featuresAsFLuxList")
    Flux<List<String>> featuresAsFLuxList() {
        List<String> whatever = Arrays.asList("Features 1", "Features 2", "Features 3");
        return Flux.just(whatever);
    }

    @GetMapping("/operate")
    void operate() {
        Flux.just("red", "white", "blue")
                .log()
                .map(String::toUpperCase)
                .subscribe(System.out::println);
        // output:
        // reactor.Flux.Array.1  : | onSubscribe([Synchronous Fuseable] FluxArray.ArraySubscription)
        // reactor.Flux.Array.1  : | request(unbounded)
        // reactor.Flux.Array.1  : | onNext(red)
        // reactor.Flux.Array.1  : | onNext(white)
        // reactor.Flux.Array.1  : | onNext(blue)
        // reactor.Flux.Array.1  : | onComplete()
    }




}   
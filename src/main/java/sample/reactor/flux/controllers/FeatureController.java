package sample.reactor.flux.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@RestController
public class FeatureController {

    public FeatureController() {
    }

    @GetMapping("/features")
    Flux<String> list() {
        return Flux.just("Features 1", "Features 2", "Features 3");
    }

    @GetMapping("/features/{id}")
    Mono<String> findById(@PathVariable String id) {
        return Mono.just("Features " + id);
    }

    @GetMapping("/featuresList")
    Flux<List<String>> flist() {
        List<String> whatever = Arrays.asList("Features 1", "Features 2", "Features 3");
        return Flux.just(whatever);
    }


}   
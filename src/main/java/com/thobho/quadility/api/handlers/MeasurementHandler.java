package com.thobho.quadility.api.handlers;

import com.thobho.quadility.commons.business.MeasurementPackage;
import com.thobho.quadility.service.MeasurementService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Controller
public class MeasurementHandler {

    private static final Logger logger = LogManager.getLogger(MeasurementHandler.class);

    @Autowired
    private MeasurementService service;

    public Mono<ServerResponse> ping(final ServerRequest serverRequest) {
        return ServerResponse.ok().body(Mono.just("Server lived" + LocalDateTime.now()), String.class);
    }

    public Mono<ServerResponse> saveMessagePackage(final ServerRequest request) {
        request.bodyToFlux(MeasurementPackage.class)
                .map(MeasurementPackage::getMeasurements)
                .flatMap(Flux::fromArray)
                .subscribe(service::sendToProcessingQueue);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just("{\"response\":\"ok\"}"), String.class);
    }
}
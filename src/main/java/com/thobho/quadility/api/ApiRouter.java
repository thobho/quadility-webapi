package com.thobho.quadility.api;

import com.thobho.quadility.api.handlers.ErrorHandler;
import com.thobho.quadility.api.handlers.MeasurementHandler;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


public class ApiRouter {

    private static final String PING_PATH = "/ping";
    private static final String MEASUREMENT_PATH = "/measurement";

    public static RouterFunction<?> doRoute(final MeasurementHandler measurementHandler, final ErrorHandler errorHandler) {
        return route(GET(PING_PATH), measurementHandler::ping)
                .andRoute(POST(MEASUREMENT_PATH).and(accept(MediaType.ALL)), measurementHandler::saveMessagePackage);
    }

}

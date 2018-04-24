package com.thobho.quadility.configuration;

import com.thobho.quadility.api.handlers.MeasurementHandler;
import com.thobho.quadility.api.handlers.ErrorHandler;
import com.thobho.quadility.api.ApiRouter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;

@Configuration
@EnableWebFlux
@EnableAspectJAutoProxy
public class ApplicationConfiguration {

    @Bean
    MeasurementHandler apiHandler() {
        return new MeasurementHandler();
    }

    @Bean
    ErrorHandler errorHandler() {
        return new ErrorHandler();
    }

    @Bean
    RouterFunction<?> mainRouterFunction(final MeasurementHandler measurementHandler, final ErrorHandler errorHandler) {
        return ApiRouter.doRoute(measurementHandler, errorHandler);
    }

    @Bean
    ModelMapper modelMapper(){
        return new ModelMapper();
    }

}

package com.thobho.quadilityr.service;

import com.thobho.quadilityr.commons.business.Measurement;
import com.thobho.quadilityr.commons.business.MeasurementPackage;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface MeasurementService {

    Flux saveMeasurements(Flux<Measurement> measurementEntity);

    Flux<Measurement> saveMeasurementPackage(Flux<MeasurementPackage> measurementPackage);
}

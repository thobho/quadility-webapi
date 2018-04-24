package com.thobho.quadility.service;

import com.thobho.quadility.commons.business.Measurement;
import com.thobho.quadility.commons.business.MeasurementPackage;
import reactor.core.publisher.Flux;


public interface MeasurementService {

    Flux saveMeasurements(Flux<Measurement> measurementEntity);

    Flux<Measurement> saveMeasurementPackage(Flux<MeasurementPackage> measurementPackage);

    Measurement sendToProcessingQueue(Measurement measurement);
}
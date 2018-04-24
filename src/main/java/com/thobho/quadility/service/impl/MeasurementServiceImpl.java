package com.thobho.quadility.service.impl;

import com.thobho.quadility.commons.business.Measurement;
import com.thobho.quadility.commons.business.MeasurementPackage;
import com.thobho.quadility.dataaccess.entities.MeasurementEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import com.thobho.quadility.service.MeasurementService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MeasurementServiceImpl implements MeasurementService {

    @Autowired
    private ReactiveMongoRepository<MeasurementEntity, String> measurementRepository;
    @Autowired
    private ModelMapper entityMapper = new ModelMapper();
    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public Measurement sendToProcessingQueue(Measurement measurement) {
        jmsTemplate.convertAndSend(measurement);
        return measurement;
    }

    @Override
    public Flux<Measurement> saveMeasurements(Flux<Measurement> measurements) {
        Flux<MeasurementEntity> entitiesToSave = measurements.transform(this::toEntity);
        return measurementRepository.saveAll(entitiesToSave).transform(this::toBusinessObject);
    }

    @Override
    public Flux<Measurement> saveMeasurementPackage(Flux<MeasurementPackage> measurementPackage) {

        return measurementPackage
                .map(MeasurementPackage::getMeasurements)
                .flatMap(Flux::fromArray)
                .transform(this::toEntity)
                .transform(measurementRepository::saveAll)
                .transform(this::toBusinessObject);
    }

    private Mono<MeasurementEntity> toEntity(Mono<Measurement> measurement) {
        return measurement.map(x -> entityMapper.map(x, MeasurementEntity.class));
    }

    private Flux<MeasurementEntity> toEntity(Flux<Measurement> measurement) {
        return measurement.map(x -> entityMapper.map(x, MeasurementEntity.class));
    }

    private Flux<Measurement> toBusinessObject(Flux<MeasurementEntity> measurement) {
        return measurement.map(x -> entityMapper.map(x, Measurement.class));
    }

    private Mono<Measurement> toBusinessObject(Mono<MeasurementEntity> measurement) {
        return measurement.map(x -> entityMapper.map(x, Measurement.class));
    }
}

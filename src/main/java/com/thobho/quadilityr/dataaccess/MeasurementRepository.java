package com.thobho.quadilityr.dataaccess;

import com.thobho.quadilityr.dataaccess.entities.MeasurementEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MeasurementRepository extends ReactiveMongoRepository<MeasurementEntity, String> {

}

package com.thobho.quadility.dataaccess;

import com.thobho.quadility.dataaccess.entities.MeasurementEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MeasurementRepository extends ReactiveMongoRepository<MeasurementEntity, String> {

}

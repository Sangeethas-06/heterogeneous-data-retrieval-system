package dataretrieval.project.repository;

import dataretrieval.project.model.UserTable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends MongoRepository<UserTable,String> {
}

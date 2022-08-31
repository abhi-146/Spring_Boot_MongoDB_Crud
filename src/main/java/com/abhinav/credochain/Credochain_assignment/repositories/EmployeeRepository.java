package com.abhinav.credochain.Credochain_assignment.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.abhinav.credochain.Credochain_assignment.models.EmployeeDetailRequest;

import java.util.List;


public interface EmployeeRepository extends MongoRepository<EmployeeDetailRequest, String> {
    @Override
    public default <S extends EmployeeDetailRequest> List<S> saveAll(Iterable<S> entities) {
        return null;
    }
}

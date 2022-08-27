package com.jsfc.store.store.repository;

import com.jsfc.store.store.collections.BillForClients;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReceiptsRepository extends ReactiveMongoRepository<BillForClients, String> {
}

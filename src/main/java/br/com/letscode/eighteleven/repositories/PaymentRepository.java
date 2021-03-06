package br.com.letscode.eighteleven.repositories;

import br.com.letscode.eighteleven.domains.Payment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends MongoRepository<Payment, ObjectId> {
    List<Payment> findByOriginAccountOrderByPaymentDate(String account);
}

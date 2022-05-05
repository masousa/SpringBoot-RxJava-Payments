package br.com.letscode.eighteleven.services;

import br.com.letscode.eighteleven.domains.Payment;
import br.com.letscode.eighteleven.payloads.CreatePaymentRequest;
import br.com.letscode.eighteleven.payloads.PaymentResponse;
import br.com.letscode.eighteleven.repositories.PaymentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreatePaymentService {

    private final PaymentRepository paymentRepository;
    private final ObjectMapper objectMapper;
    public Single<PaymentResponse> execute(CreatePaymentRequest request) {
        return Single.create(emitter -> {
            Payment payment = objectMapper.convertValue(request, Payment.class);
            payment.setUuid(UUID.randomUUID().toString());
            payment.setProcessed(LocalDate.now().isEqual(request.getPaymentDate()));
            emitter.onSuccess(converter(paymentRepository.save(payment)));
        });
    }

    private PaymentResponse converter(Payment save) {
        return objectMapper.convertValue(save, PaymentResponse.class);
    }
}

package br.com.letscode.eighteleven.services;

import br.com.letscode.eighteleven.converters.PaymentToPaymentResponseConverter;
import br.com.letscode.eighteleven.domains.Payment;
import br.com.letscode.eighteleven.payloads.CreatePaymentRequest;
import br.com.letscode.eighteleven.payloads.PaymentResponse;
import br.com.letscode.eighteleven.repositories.PaymentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreatePaymentService {

    private final PaymentRepository paymentRepository;
    private final ObjectMapper objectMapper;

    private final PaymentToPaymentResponseConverter paymentToPaymentResponseConverter;
    public Single<PaymentResponse> execute(CreatePaymentRequest request) {

        return Single.create(emitter -> {
            log.info("Dormindo");
            Thread.sleep(5000);
            var payment = objectMapper.convertValue(request, Payment.class);
            payment.setUuid(UUID.randomUUID().toString());
            payment.setProcessed(LocalDate.now().isEqual(request.getPaymentDate()));
            log.info("Finalizado em {}", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            emitter.onSuccess(paymentToPaymentResponseConverter.converter(paymentRepository.save(payment)));
        });
    }

}

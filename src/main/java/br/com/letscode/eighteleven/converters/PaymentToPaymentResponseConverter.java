package br.com.letscode.eighteleven.converters;

import br.com.letscode.eighteleven.domains.Payment;
import br.com.letscode.eighteleven.payloads.PaymentResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentToPaymentResponseConverter {
    private final ObjectMapper objectMapper;

    public PaymentResponse converter(Payment save) {
        return objectMapper.convertValue(save, PaymentResponse.class);
    }
}

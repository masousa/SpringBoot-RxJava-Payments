package br.com.letscode.eighteleven.services;

import br.com.letscode.eighteleven.converters.PaymentToPaymentResponseConverter;
import br.com.letscode.eighteleven.payloads.PaymentResponse;
import br.com.letscode.eighteleven.repositories.PaymentRepository;
import io.reactivex.rxjava3.core.Observable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPaymentsByAccountService {
    private final PaymentRepository paymentRepository;
    private final PaymentToPaymentResponseConverter paymentToPaymentResponseConverter;
    public Observable<PaymentResponse> execute(String account) {
           return Observable.fromIterable(paymentRepository
                   .findByOriginAccountOrderByPaymentDate(account))
                   .map(paymentToPaymentResponseConverter::converter);
    }
}

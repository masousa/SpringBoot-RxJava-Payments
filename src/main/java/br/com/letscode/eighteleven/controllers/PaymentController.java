package br.com.letscode.eighteleven.controllers;

import br.com.letscode.eighteleven.domains.Payment;
import br.com.letscode.eighteleven.payloads.CreatePaymentRequest;
import br.com.letscode.eighteleven.payloads.PaymentResponse;
import br.com.letscode.eighteleven.services.CreatePaymentService;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments/v1")
@RequiredArgsConstructor
public class PaymentController {

    private final CreatePaymentService createPaymentService;

    @PostMapping(path = "/", produces = "application/json")
    public Single<PaymentResponse> createPayment(@RequestBody CreatePaymentRequest request){
        return createPaymentService.execute(request);
    }
}

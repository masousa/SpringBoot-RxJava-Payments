package br.com.letscode.eighteleven.controllers;

import br.com.letscode.eighteleven.domains.Payment;
import br.com.letscode.eighteleven.payloads.CreatePaymentRequest;
import br.com.letscode.eighteleven.payloads.PaymentResponse;
import br.com.letscode.eighteleven.services.CreatePaymentService;
import br.com.letscode.eighteleven.services.GetPaymentsByAccountService;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments/v1")
@RequiredArgsConstructor
public class PaymentController {

    private final CreatePaymentService createPaymentService;

    private final GetPaymentsByAccountService getPaymentsByAccountService;

    @PostMapping(path = "/", produces = "application/json")
    public Single<PaymentResponse> createPayment(@RequestBody CreatePaymentRequest request){
        return createPaymentService.execute(request);
    }

    @GetMapping(path="/{account}", produces = "application/json")
    public Observable<PaymentResponse> getByAccount(@PathVariable String account){
        return getPaymentsByAccountService.execute(account);
    }
}

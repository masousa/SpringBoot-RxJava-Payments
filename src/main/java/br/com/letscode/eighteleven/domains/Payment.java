package br.com.letscode.eighteleven.domains;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "payments-transactions")
public class Payment {
    @Id
    private ObjectId id;
    private String uuid;

    @JsonProperty("account")
    private String originAccount;
    private String transaction;
    private Boolean processed;

    @JsonProperty("payment-date")
    private LocalDate paymentDate;
    @JsonProperty("due-date")
    private LocalDate dueDate;

    @JsonProperty("debitValue")
    private Double debitValue;
    @JsonProperty("paid-value")
    private Double paidValue;

    @JsonProperty("payment-info")
    private PaymentAccount paymentAccount;



}

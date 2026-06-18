package PleinGaz.transaction_service.controller;

import PleinGaz.transaction_service.model.Transaction;
import PleinGaz.transaction_service.service.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")//url vers la transaction
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(
            TransactionService transactionService) {

        this.transactionService = transactionService;
    }

    @PostMapping
    public Transaction createTransaction(
            @RequestBody Transaction transaction) {

        return transactionService.createTransaction(transaction);
    }
}
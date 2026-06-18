package PleinGaz.transaction_service.service;

import PleinGaz.transaction_service.model.Transaction;

public interface TransactionService {

    Transaction createTransaction(Transaction transaction);
}
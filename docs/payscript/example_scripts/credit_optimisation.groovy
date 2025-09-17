trigger = "transaction";

var savingsAccount = ${savingsAccount:AccountInfo};
var percentageToTransfer = ${percentageToTransfer:decimal};
var saveOnTransactionsOver = ${saveOnTransactionsOver:decimal};

var incomingPaymentAmount = getTriggerTransactionDetails().getAmount().getAmount();

if (incomingPaymentAmount.compareTo(saveOnTransactionsOver) < 0) {
    return;
}

var amountToTransfer = incomingPaymentAmount.multiply(percentageToTransfer).divide(100);
var currentAccount = getAutomationOwnerAccountInfo();
var transfer = PaymentInfo.builder()
        .payer(currentAccount)
        .payee(savingsAccount)
        .amount(AmountInfo.builder()
                .currency(Currency.GBP)
                .amount(amountToTransfer)
                .build())
        .reason("Credit Optimisation")
        .build();

createPayment("e70fefd2-c52a-46c2-848d-cd7a6d9bcacd",transfer);

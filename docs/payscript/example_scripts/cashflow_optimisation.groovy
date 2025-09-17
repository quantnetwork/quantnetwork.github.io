trigger = "time";

var savingsAccount = ${savingsAccount:AccountInfo};
var minAmount    = ${minimumAccountBalance:decimal};
var maxAmount    = ${maximumAccountBalance:decimal};

var bankAccount = getAutomationOwnerAccountInfo();
var bankAccountBalance = getBalance(bankAccount);
var bankAccountBalanceAmount = bankAccountBalance.availableBalance;

if (bankAccountBalanceAmount.compareTo(minAmount) > 0) {
    def transferAmount = bankAccountBalanceAmount.subtract(minAmount);
    if (transferAmount.compareTo(maxAmount) > 0) {
        transferAmount = maxAmount;
    }
    var transferFromCurrentToSaving = PaymentInfo.builder()
            .payer(bankAccount)
            .payee(savingsAccount)
            .amount(AmountInfo.builder()
                    .currency(Currency.GBP)
                    .amount(transferAmount)
                    .build())
            .reason("Cash-flow management")
            .build();
    var payment = createPayment("502652ac-8643-40ee-8275-fd89d449e88f", transferFromCurrentToSaving);
    logMessage("Cash-flow management completed successfully with amount" + transferAmount + "with payment ID: " + payment.paymentId);
} else {
    logMessage("Cash-flow management: the balance (" + bankAccountBalanceAmount + ") doesn't meet the threshold (" + minAmount + ")");
}

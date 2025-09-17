trigger = "time";

def account_parent = ${account_parent:scan};
def account_child = ${account_child:scan};
def topUpGoal = ${topUpGoal:decimal};

balance = getBalance(account_child);

if (balance < topUpGoal) {
    def payment = PaymentInfo.builder()
        .payer(AccountInfo.builder()
                .type(AccountIdentifierType.SCAN)
                .identifier(account_parent)
                .build())
        .payee(AccountInfo.builder()
                .type(AccountIdentifierType.SCAN)
                .identifier(account_child)
                .build())
        .amountInfo(AmountInfo.builder()
                .currency(CurrencyEnum.GBP)
                .amount(topUpGoal - balance)
                .build())
        .paymentReference("Top-up payment.")
        .build();
    createPayment(payment);
}
trigger = "on_demand";

def payer  = ${payer:scan};
def payee = ${payee:scan};
def amount = ${amount:decimal};

def payment = PaymentInfo.builder()
        .payer(AccountInfo.builder()
                .type(AccountIdentifierType.SCAN)
                .identifier(payer)
                .build())
        .payee(AccountInfo.builder()
                .type(AccountIdentifierType.SCAN)
                .identifier(payee)
                .build())
        .amountInfo(AmountInfo.builder()
                .currency(CurrencyEnum.GBP)
                .amount(amount)
                .build())
        .paymentReference("Automated transfer")
        .build();

def newPaymentId = createPayment(payment);
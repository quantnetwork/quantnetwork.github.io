trigger = transaction(payer = anyExcept(), payee=OWNER);

var savingsAccount = ${savingsAccount:AccountInfo};
var taxPercentage = ${taxPercentage:decimal};

if(taxPercentage <=BigDecimal.ZERO ||taxPercentage >BigDecimal.valueOf(100)){
    throw new IllegalArgumentException("Invalid taxPercentage:"+taxPercentage +" Must be > 0 and ≤ 100.");
}

var triggerTransactionAmount = getTriggerTransactionDetails().getAmount().getAmount();
var currentAccount = getAutomationOwnerAccountInfo();

var saveTaxAmount = triggerTransactionAmount
        .multiply(taxPercentage)
        .divide(BigDecimal.valueOf(100));

var payment = PaymentInfo.builder()
        .payer(currentAccount)
        .payee(savingsAccount)
        .amount(AmountInfo.builder()
                .currency(Currency.GBP)
                .amount(saveTaxAmount)
                .build())
        .reason("Save Tax")
        .build();

var newPaymentId = createPayment("69c47867-49f6-481e-a8a9-248d75349f47", payment);

logMessage("Saving tax completed successfully with paymentId:"+newPaymentId +" ");

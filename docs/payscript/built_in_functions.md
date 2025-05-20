---
title: Built-in Functions
parent: Payscript
layout: page
---

# built in functions
PayScript offers built-in functions as the interface to interact with banking systems, as well as other utilities. This is the comprehensive list of functions available.


## Account Functions

## `boolean accountExists(AccountIdentifier accountIdentifier)`
Checks whether an account exists.


## `boolean checkAccountFunds(AccountIdentifier accountIdentifier, BigDecimal amount)`
Checks whether an account has the required funds available.


## `BalanceInfo getBalance(AccountIdentifier accountIdentifier)`
Shows the total balance and available balance for an account.


## `List<RelatedAccountInfo> getRelatedAccountIds(AccountIdentifier accountIdentifier)`
Retrieve the number of accounts related to a specified account.


## `ConsentStatus getConsent(AccountIdentifier giverAccountId, AccountIdentifier holderAccountId, ConsentType type)`
Retrieve consent status for a particular account.


## Payment Functions

## `UUID createPayment(String payerAccountNumber, String payeeAccountNumber, BigDecimal amount, String purpose)`
Makes a payment between two accounts.

## `UUID requestPayment(String payerAccountNumber, String payeeAccountNumber, BigDecimal amount, String purpose)`
Sends a payment request from one account to another.

## `Payment getPaymentInfo(String paymentId)`
Retrieve payment information for payment with `paymentId`.

## `UUID requestPayment(PaymentInfo paymentInfo)`
Sends a request for `paymentInfo`.

## `String createPayment(PaymentInfo paymentInfo)`
Creates a payment based on `paymentInfo`.


## Lock Functions

## `String createLock(LockInfo lockInfo)`
Creates a lock based on the data object `LockInfo`, returning the ID of the created lock.

## `String getLockStatus(String lockId)`
Returns the status of the lock with id `lockId`

## `Lock getLockInfo(String lockId)`
Returns the Lock object with `lockId`

## `void releaseLock(String lockId)`
Releases the funds from the lock lock with `lockId`

## `List<LockInfo> getAccountLocks(AccountIdentifier accountIdentifier)`
Return a list of `LockInfo` representing all the locks which belong to the account identified by `accountIdentifier`



## Reserve Functions

## `addFundsToReserve(String fromAccount, String toReserve, decimal amount, String reference)`
Sets aside an `amount` of funds from the account `fromAccount` into the reserve `toReserve`. The transaction reference used is the text `reference`.


## `withdrawFundsFromReserve(fromReserve, toAccount, amount, reference);`
Withdraws an `amount` of funds into the account `toAccount` from the reserve `fromReserve`. The transaction reference used is the text `reference`.

## `editReserve(UpdateReserveInfo updateReserveInfo)`
Applies the update defined in the object [`updateReserveInfo`](#updatereserveinfo).

## `deleteReserve(String reserveId)`
Deletes the reserve with ID `reserveId`.


## Script Functions

## `Object callScript(String scriptId,  List<Map<String, Object>>... params)`
Triggers a script which has trigger type "sub_script", passing `params` as its list of map of parameter names to parameters.


# Data Objects
Data objects are used as parameters in some built-in functions. Their attributes can be accessed by default getters and setters. The data objects can be instantiated through the [builder pattern](). For example:
```groovy
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
        .paymentReference("This is a payment.")
        .build();
```

## `BalanceInfo`
`BigDecimal totalBalance`: A total balance of funds in an account, which includes funds in locks and reserves.<br>
`BigDecimal availableBalance`: The balance of funds in an account which is not committed to locks or reserves.<br>


## `PaymentInfo`
`UUID id`: The unique identifier of the payment<br>
`AccountInfo  payer`: The account providing funds<br>
`AccountInfo  payee`: The account receiving funds<br>
`AmountInfo amount`: Amount of funds being transferred<br>
`String purpose`: Text that should provide context for the payment<br>
`PaymentStatus status`: <br>
`Instant createdAt`: <br>
`Instant updatedAt`:<br>

## `UpdateReserveInfo`
Creates an object containing values to use to update a [Reserve]()'s attributes.<br>
`String reserveId`: The UUID of the existing reserve<br>
`String name`: The name to be applied with the update<br>
`Integer priority`: The priority number to be applied with the update<br>
`BigInteger SavingGoal`: The goal of savings to be applied with the update<br>
`String description`: The description to be applied with the update<br>

## `GetAmountInfoResponse`
`Amount totalBalance`<br>
`Amount availableBalance`<br>

## `Lock`
`UUID lockId`: The global ID of the lock<br>
`Instant createdAt`: The Instant representing the time at which the Lock was created<br>
`BigDecimal amount`: The amount of funds that are locked by this Lock<br>
`String currency`: The currency of the funds locked by this lock<br>
`UUID to`: Whom the funds locked by this lock have been locked to<br>
`Instant expiryDate`: An Instant representing the time from which the lock will expire<br>
`String description`: A descriptive text about the lock<br>
`String status`: Status of the lock<br>


See an [example of reserve update][updateReserve.md].


[updateReserve.md]: example_scripts/updateReserve.groovy
[builder pattern]: https://refactoring.guru/design-patterns/builder
[reserve]: 
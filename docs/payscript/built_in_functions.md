---
title: Built-in Functions
parent: Payscript
layout: page
---

# built in functions

## Account Functions

## `boolean accountExists(AccountIdentifier accountIdentifier)`
Checks whether an account exists.


## `boolean checkAccountFunds(AccountIdentifier accountIdentifier, BigDecimal amount)`
Checks whether an account has the required funds available 


## `BalanceInfo getBalance(AccountIdentifier accountIdentifier)`
Shows the total balance and available balance for an account


## `List<RelatedAccountInfo> getRelatedAccountIds(AccountIdentifier accountIdentifier)`
Retrieve the number of accounts related to a specified account

## `ConsentStatus getConsent(AccountIdentifier giverAccountId, AccountIdentifier holderAccountId, ConsentType type)`
Retrieve consent status for a particular account

## Payment Functions

## `UUID createPayment(String payerAccountNumber, String payeeAccountNumber, BigDecimal amount, String purpose)`
Makes a payment between two accounts

## `UUID requestPayment(String payerAccountNumber, String payeeAccountNumber, BigDecimal amount, String purpose)`
Sends a payment request from one account to another

## `getPaymentInfo`
Retrieve payment information



## Reserve Functions

`addFundsToReserve(String fromAccount, String toReserve, decimal amount, String reference)`
Sets aside an `amount` of funds from the account `fromAccount` into the reserve `toReserve`. The transaction reference used is the text `reference`.


`withdrawFundsFromReserve(fromReserve, toAccount, amount, reference);`
Withdraws an `amount` of funds into the account `toAccount` from the reserve `fromReserve`. The transaction reference used is the text `reference`.

### Create Reserve Update
**`new UpdateReserveInfo(reserveId, name, priority, savingGoal, description)`**

Creates an object containing values to use when updating a [Reserve]'s attributes.


### Apply Reserve Update
**`editReserve(UpdateReserveInfo updateReserveInfo)`**
Applies the update defined in the object `updateReserveInfo`.


See an [example of reserve update][updateReserve.md].


### Delete
**`deleteReserve(String reserveId)`**
Deletes the reserve with ID `reserveId`.


[updateReserve.md]: example_scripts/updateReserve.groovy
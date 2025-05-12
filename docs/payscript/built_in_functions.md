---
title: Built-in Functions
parent: Payscript
layout: page
---

built in functions

## Reserve functions

### Add Funds
`addFundsToReserve(String fromAccount, String toReserve, decimal amount, String reference)`

Sets aside an `amount` of funds from the account `fromAccount` into the reserve `toReserve`. The transaction reference used is the text `reference`.

### Withdraw Funds
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
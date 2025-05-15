---
title: Concepts
parent: Payscript
layout: page
nav_order: 4
---


## Automation
An entity created by a [customer] into their bank account. The automation is created from a PayScript from among the ones that have been deployed by [developers]. If the selected payscript uses a trigger type that requires [trigger parameters], those need to be specified as part of creating the automation. If the selected payscript defines [script parameters], those need to be specified as part of creating the automation.

## Reserve
An abstract segregation of funds in a customer's account with a name and a purpose, so that those funds can be considered unavailable for other purposes, effectively reserving them. Funds can be added to and removed from the reserve by the account owner, or by whoever the account owner has given [consent] to do this.

## Consent
Consent is given by a [customer] to another customer perform specific actions on their accounts. The types of consent that can be given are:
Fund check: Allows checking if the owner has more available funds than a given amount
Automations: 
Balance: Allows seeing the balance of the owner
Transactions: Allows making transactions on behalf of the owner

[customer]: /docs/quant_flow/personas#customer
[developers]: /docs/quant_flow/personas#developer
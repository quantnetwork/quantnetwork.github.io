---
title: Reserve Funds
parent: Example Scripts
layout: page
---


```groovy
trigger="on_demand";

def fromAccount = new Scan(${sortCode:string}, ${accountNumber:string});
def toReserve = ${toReserve:string};
def amount = ${amount:decimal};
def reference = ${reference:string?};

addFundsToReserve(fromAccount, toReserve, amount, reference);
```
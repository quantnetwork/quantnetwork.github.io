---
title: Triggers
layout: page
parent: Payscript
---

## Triggers
Triggers specify which type of event will cause the script to run. They take parameters, which are only given during the creation of an Automation (not when the script is written or deployed). These are the types of triggers available:

**Time / Date**: Runs on a schedule, specified at the time when the automation is created. For example, daily at 14:00, or monthly on the first day of the month, at 00:00. The time parameter is specified when an automation is created with this script.

**Balance**: Runs whenever the balance of an account is a certain number or above or below a specified number.

**Transaction**: Runs whenever a transaction happens on a specified account. This

**On Demand**: This will cause the automation to have a button which can be used to run it at any time.

**SubScript**: Runs when it is triggered by a function call in another script. The subscript trigger type does not allow any parameters. The function used for this is [callScript][callScript]


Some triggers take parameters.  will only be specified at the time when it is used in the creation of an automation.

The trigger definition follows the syntax:
```groovy
trigger="TRIGGER_TYPE";
```
where TRIGGER_TYPE is replaced by a trigger type name. <br>
Example: `trigger="time";`

[callScript]: built_in_functions.html#object-callscriptstring-scriptid--listmapstring-object-params
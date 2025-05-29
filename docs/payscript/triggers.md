---
title: Triggers
layout: page
parent: Payscript
---

## Triggers
Triggers specify which type of event will cause the script to run. They take parameters, which are only given during the creation of an Automation (not when the script is written or deployed). These are the types of triggers available:

**Time / Date**: These triggers run at scheduled times. The trigger is set by defining the following at the start of the Script.
```groovy
trigger="time"; 
```
This type of trigger will make the automation run automatically on a schedule set by the system. 
The following timescales should be supported by Payscript:
-Daily: Executes every day at a specified time (e.g., every day at 12:00 pm).
-Weekly: Executes on selected weekdays at a specified time (e.g., every Monday at 12:00 pm).
-Monthly: Executes on a specific day of the month or the last working day at a specified time (e.g., 2nd of every month at 12:00 pm).
-Yearly: Executes on a specific date and month at a specified time (e.g., every year on 21st of January at 12:00 pm).
-One time: Executes once at a specified date and time (e.g., 12th of January 2026 at 12:00 pm
-Every X Hours: Executes at regular hourly intervals (e.g., every 2 hours).
-Every X Minutes: Executes at regular minute intervals (e.g., every 10 minutes).

**Balance**: These triggers cause an automation when an account balance changes and meets a certain condition i.e. balance is above £X.<br>
Also if the balance is equal to X or more than X. We have these three comparison types. LESS THAN, EQUAL, MORE THAN<br>
The trigger is set by defining the following at the start of the Script.<br>
```groovy
trigger="balance";
```

**Transaction**: Some scripts run when a specific event happens, such as a payment being received. The trigger is set by defining the following at the start of the Script.
```groovy
trigger="transaction"; 
```
This makes the script run whenever a payment is made or received in a monitored account. BUT…. You have to specify the payer, payee and amount for the trigger, so it’s currently extremely specific – this is getting updated. <br>
Users also have the ability to specify within the parameters, to trigger certain automations when a transaction for , any payer, any payer or any amount happen on an account e.g. whenever i I receive a payment of any amount from any payer, move 20% to my savings account.<br>
Additionally, we applied the rule that the customer setting the automation must be either the payer or the payee.<br>

**On Demand**: This allows users to manually execute pre-configured automations by pressing a trigger button which is available(in UI) only for on-demand automations.
```groovy
trigger="on_demand"; 
```
 We support two ways of executing on-demand triggers:
- From the UI button: This uses the values already set within the automation. Users can manually trigger pre-configured automations by pressing a button, which is available only for automations of type on_demand.
- Via API call: This allows external systems or users to trigger the automation by calling the endpoint /customers/{customerId}/automations/{automationId}/execution and passing the required values directly in the request payload. The automation will run with the provided values instead of the pre-set one.

**Sub-script**: This trigger allows the ability to call scripts which are inside other scripts which, do not have any trigger parameters and the only way to trigger them is when another script calls them. Scripts with this trigger type can only be invoked within another script.
```groovy
trigger="subscript"; 
```
- Scripts with this trigger type cannot be used in independent automation and will not appear in the deployed scripts list on the "Add Automation" page
- During automation set up, only script A parameters should be required
- To call a script within another, use callScript(UUID scriptId, final Object... params), passing the necessary values (like transaction Id generated during execution).
- There is validation applied when deploying a script that is related to another so that the developer knows which other scripts are required


Some triggers take parameters.  will only be specified at the time when it is used in the creation of an automation.

The trigger definition follows the syntax:
```groovy
trigger="TRIGGER_TYPE";
```
where TRIGGER_TYPE is replaced by a trigger type name. <br>
Example: `trigger="time";`

[callScript]: built_in_functions.html#object-callscriptstring-scriptid--listmapstring-object-params
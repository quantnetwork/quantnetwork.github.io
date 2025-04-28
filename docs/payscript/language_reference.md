---
title: Language Reference
parent: Payscript
layout: page
nav_order: 1
---

## Payscript
Payscript is a domain specific language (DSL) derived from Groovy. Using the Groovy syntax, with additional [built-in functions], it is able to cover the functionality needed to operate in the environment of a financial services provider. 

For Syntax, this version does not differ from Groovy. please consult the [Groovy syntax reference][groovy syntax]. 

## Script Structure
A payscript is structured in such a way to best meet the needs of the architecture proposed by Quant Flow. During the script’s lifecycle it's expected to be deployed by developers into a collection, and to be made available to use with Automations. 

[comment]: Add image 

## Triggers
Triggers specify which type of event will cause the script to run. They take parameters, which are only given during the creation of an Automation (not when the script is written or deployed). These are the types of triggers available:

**time**: This trigger will cause the script to be run on a schedule, specified at the time when the automation is created. For example, daily at 14:00, or monthly on the first day of the month, at 00:00.

**balance**: This trigger will cause the script to run whenever the balance oft  owns it is a certain number or above or below a specified number.

**transaction**: This trigger will cause the script to run whenever a transaction happens on the account who owns the script.

The actual values for these triggers (trigger parameters) will only be specified at the time when it is used in the creation of an automation.

The trigger definition follows the syntax:

trigger="[trigger]";

where [trigger] is replaced by a trigger type name. Example: trigger="time";


## Parameters
The script parameters are values which will be used by the script but will be specified by the user who creates an automation which uses this script. At that time they will be prompted for the values, much like the trigger parameters.

Parameters are specified in the script using the following syntax:

```groovy
"${[parameter name]}"
```

Where [parameter name] is to be replaced with the name of the parameter, as will be shown to the user during the creation of an automation using this script.

## Logic
The logic section contains what the script needs to accomplish, utilizing groovy logic and the payscript built-in functions.


[groovy syntax]: https://groovy-lang.org/single-page-documentation.html
[built-in functions]: built_in_functions
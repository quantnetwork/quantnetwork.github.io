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
PayScript has two special structures, beyond the programming logic; A [trigger] definition and [script parameters]. The trigger specifies what type of event will cause the script to run. When an automation is created with the script, the parameters of the trigger will be specified. For example, if the script's trigger type is "time", the parameters would be which date and time it should run on.
Also during the creation of the automation, the script parameters required by the script will be supplied.

## Parameters
The script parameters are values which will be used by the script but will be specified by the customer who creates an automation which uses this script. At that time they will be prompted for the values, much like the trigger parameters.

Parameters are specified in the script using the following syntax:

```groovy
"${[parameter name]}"
```

Where [parameter name] is to be replaced with the name of the parameter, as will be shown to the user during the creation of an automation using this script.

## Logic
The logic section contains what the script needs to accomplish, utilizing groovy logic and the payscript built-in functions.


[groovy syntax]: https://groovy-lang.org/single-page-documentation.html
[built-in functions]: built_in_functions
[callScript]: built_in_functions#callScript
[trigger]: /docs/payscript/triggers
[script parameters]: #parameters
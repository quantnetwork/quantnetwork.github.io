---
title: 1 - Deploying a script
parent: Tutorials
layout: page
nav_order: 1
---

# Deploying a script
This tutorial will guide you through deploying and running your first payscript which will allow the customer to move funds to a reserve. 
We will use the [Sandbox] environment to deploy a script, create an automation and run it.

### Prerequisites:
- Have a Sandbox account


## The script
Please take a look at the script we will use:
```groovy
trigger="on_demand";

def fromAccount = new Scan(${sortCode:string}, ${accountNumber:string});
def toReserve = ${toReserve:string};
def amount = ${amount:decimal};
def reference = ${reference:string?};       

addFundsToReserve(fromAccount, toReserve, amount, reference);
```
It consists of three parts. 
The first part of any script is the [trigger]. It defines what type of conditions will cause the script to run. This script will run "on demand" which means we will be able to trigger it by clicking a button, however different trigger types can allow the script to be run on a schedule, whenever a transaction happens, or even triggered by other scripts.
The second part is the parameter definitions. In payscript, the sequence `${parameterName:type}` defines a script parameter, which is information that is required to be filled by the user in order to create an automation from this script.
The third part is the script's logic, which in this example is simply one call of a built-in function to add funds to a reserve.

Save this script in your computer as `funds_to_reserve.groovy`

## Deployment
In order for the customers to create automations, the script must be deployed first. To do this, log in to the Sandbox environment and navigate to the developer tab.

![developer view](/assets/images/tutorial1/developer_view.png)

Click the Import Button and fill in the information for the script you are deploying:
- Name and Description: The name and description of the script as will be seen by customers. 
- Category: a purely organizational category for the script
- Upload file: select the file you created in the previous step.

![deployed script](/assets/images/tutorial1/deployed_script.png)

After uploading, your script should appear like this at the top of the list. The Actions column has the green rocket button. Click that one to deploy the script, and make it available for customers.

This ends the work necessary from a developer's perspective.

## Creating a reserve
From now on we will be using the system as a customer; select the customer view from the top tab, and choose a customer to "log in" as.

![alices_view](/assets/images/tutorial1/alices_view.png)

<div style="text-align: center;">
    <img src="/assets/images/tutorial1/create_reserve.png" width="40%">
</div>

Under the customer's reserves tab, create a new reserve if the customer doesn't already have one.

<div style="text-align: center;">
    <img src="/assets/images/tutorial1/created_reserve.png" width="90%">
</div>

Once the reserve is created you are able to view information about it by selecting it from the list. On this page you can get the reserve ID by clicking the Copy icon. You will need this ID to create the automation, as well as the account holder's sort code and account number.

## Creating an automation

<div style="text-align: center;">
    <img src="/assets/images/tutorial1/create_automation.png" width="90%">
</div>
Go to the Automations tab and click the button to create a new automation.

<div style="text-align: center;">
    <img src="/assets/images/tutorial1/add_automation1.png" width="80%">
</div>
Choose a name for this automation, that makes sense to the customer who owns it. Select which script will be used in this automation, which in this case should be the script we deployed in previous steps. (If you don't see it here, you probably forgot to click the deploy button in the developer view.)

<div style="text-align: center;">
    <img src="/assets/images/tutorial1/add_automation2.png" width="60%">
</div>

Fill in the details to be used in the automation:
- Account Number & Sort Code: The bank details of the account which is funding the reserve.
- Amount: The amount that will be transfered every time the automation runs.
- Reference: The transaction reference, a string that is registered on each transaction made, to help identify its purpose.
- To Reserve: The ID of the reserve that will receive the funds. You can get this from the reserve page.

<div style="text-align: center;">
    <img src="/assets/images/tutorial1/created_automation.png" width="60%">
</div>

Now the automation is created! Because its trigger type is "on demand", you can click the green triangle button to run it whenever you wish.

Once run, you will see the transaction it created in the transaction history of the customer's account.


<div style="text-align: center;">
    <img src="/assets/images/tutorial1/automation_successful.png" width="80%">
</div>

Success!

With this basic example you were able to deploy a payscript in the Sandbox and understand how it can be used by a customer, giving you a broad idea of all the possibilities. 

In the next tutorial we will introduce the concept of consent, which will be necessary to perform transactions on behalf of a different customer.

# Next:
- [2 - Consent]

[2 - Consent]: /docs/tutorials/tutorial2

[sandbox]: /docs/sandbox
[trigger]: /docs/payscript/language_reference.html#triggers

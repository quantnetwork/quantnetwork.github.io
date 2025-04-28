---
title: 1 - Deployment and Functions
parent: Tutorials
layout: page
nav_order: 1
---
# Deployment and Functions
This series of tutorials aim to introduce concepts and features of Quant Flow by guiding the reader through implementing small projects in the [sandbox] environment. Each tutorial gradually makes use of new concepts to showcase their functionality in a hands-on approach.

This first tutorial will guide you through using the sandbox to automate a daily transfer between two [accounts](). We will go step by step through how to write, upload and deploy a script, and create the automation to make use of it.

**Concepts**:

- [automation]()
- [language reference]()
- [Built-in Functions: createPayment]()

[comment]: Specify how to get access to the sandbox

## 1 - Creating the script
```groovy
trigger="time";

createPayment("61f56f07-9994-43b2-96c5-4479bcec3c3b", "0ade76e4-fe43-4a79-a88d-9dabfad3d5a1", 1.50, "Automated transaction.");
```

The simplest payscript requires a trigger definition; a specification of which event will cause it to run. Here it is set to time. We will use the built-in function makePayment() to make a payment between two user accounts.

The first parameter should be the number of the account from which the payment is originating. The second parameter should be the number of the account receiving the payment. 

[comment]: add image of the customer view showing the account number

You can find these account numbers by navigating to the customer view and logging in as the customers whose numbers you want. For this tutorial, any two will do.

Then, the payment amount, which is a number of the type BigDecimal. Lastly, a string that describes the purpose of the payment, which will be shown in the payment later on when it is displayed on the user's transaction history.

Next, save this file as `daily_transaction.groovy`.

## 2 - Deploying the script
Once you have the groovy file containing your payscript, log into your sandbox account. Navigate to the developer view.

Here you will find the import button. Click it, and fill the form presented, selecting the file to upload as well.

After that, you should see your script listed, however it is not yet deployed, which means it's still not available for customers to use in their automations. 

Click the deploy button (the green rocket icon) in your script in the list. Its value on the status column will change to deployed, with a green check mark. Now it is available for users.

## 3 - Create an automation
Navigate to the customer view, under the tab `Automations`. Here each customer can manage the automations relative to their own accounts.

Click on the `Add Automations` button, and you will be prompted to pick which of the deployed scripts you will use. Name the new automation as "Customer's Automated Transaction" and click `add` from the `Automated Transaction` one, which will be available since we deployed it in the previous step.

Now the automation has been created under the customer's account, but it still needs to be activated. Click on the green gear icon in your listed automation, which will bring up the form for the automation options.

For the Occurrence, select "Daily" from the drop-down options, and for the time, pick a time that is a minute or two in the future so we can see the results of the automation soon.
Click `Save`, and wait for the time you specified.

The UI will prompt you to request any necessary consents, however, we won't need to request any consents in order for this specific automation to run. The use of consent will be covered in the next tutorial.

## Results

Once the automation has been created, it will run daily at the specified time. Once it has run, you will be able to verify the transaction in the customer's transaction history, under the "Account Info" tab.

Congratulations! You have just deployed a simple payscript automation. 

Next steps

The next tutorial will introduce the concept of consent, which will be required to set up more complex Automations.


### Next:
- [2 - Consent]

[2 - Consent]: /docs/tutorials/tutorial2
[sandbox]: /docs/sandbox
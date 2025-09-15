---
title: Manage Your Connected Accounts
parent: Connect Your Bank Accounts
layout: default
nav_order: 3
---

# Managing Consents and Connected Accounts

You have full visibility and control over all your company's bank connections from the Quant Flow dashboard.

## Viewing Connected Accounts

The **Bank Accounts** overview page shows all accounts associated with your `CompanyID`, including:
*   **Account Name/Nickname**
*   **Bank Name**
*   **Account Number** (masked for security)
*   **Status:** (e.g., `Active`, `Inactive`, `Expired`, `Authorised`, `Revoked`)
*   **Consent Expiry Date**

## Extending Consent

For UK accounts, you must renew consent every 90 days.
1.  The system will show an **"In X days your bank account will expire, please extend"** warning next to relevant accounts.
2.  An Admin User can click **"Extend"** button.
3.  You will be guided through the same secure authentication process with your bank to grant a new 90-day consent. Your existing automations will continue to run without interruption.

## Deactivating an Account

You can deactivate an account at any time.
1.  Find the active account and select **"Deactivate"**.
2.  **Important Consideration:** Deactivating an account will pause **all automations** associated with it. This may disrupt scheduled payments, data feeds, or reconciliation processes. You will be asked to confirm this action.
3.  The account will move to an **"Inactive"** state but will retain its consent, allowing you to easily reactivate it later without going through the full bank authorization again (as long as the consent is still valid).

## Revoking Consent Entirely

If you wish to permanently remove Quant Flow's access to an account:
1.  You can **"Revoke Consent"** from either an Active or Inactive account.
2.  This action is irreversible and severs the connection to your bank.
3.  All automations for this account will be permanently halted.
4.  To use this account again in the future, you will need to start from the beginning of the consent process.
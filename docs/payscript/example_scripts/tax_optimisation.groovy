trigger = "transaction";  // Trigger definition - The automation will trigger on specified transactions.

// Define the parameters required
def reserveId   = ${reserveId:String};  // The reserve where tax will be sent to
def taxFactor    = ${taxFactor:decimal};  // What portion of the payment is owed in taxes


// Basic validation
if (taxFactor <= BigDecimal.ZERO || taxFactor > BigDecimal.ONE) {
    throw new IllegalArgumentException("Invalid taxFactor: ${taxFactor}. Must be > 0 and ≤ 1.");
}


// Unpack values from the payment event that triggered this script.
def eventPaymentId = event[paymentId:string];
def eventPaymentInfo = getPaymentInfo(eventPaymentId);
def eventPaymentAmount = eventPaymentInfo.amountInfo.amount;


// Calculate the tax amount to be saved
def saveTaxAmount = eventPaymentAmount.multiply(taxFactor);

// Add funds to reserve
addFundsToReserve(eventPaymentInfo.payee.identifier, reserveId, saveTaxAmount, "Automated tax optimisation");

// Log useful information
println("Saving tax completed successfully to reserve: ${reserveId}");

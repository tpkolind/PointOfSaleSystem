/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProcessSale;

// Imports
import java.util.ArrayList;
import java.util.Date;

// Class to perform a sale
public class Sale {
    
    // Class variables
    boolean isComplete;
    Date time;
    ArrayList<SalesLineItem> cart;
    
    // Constructor
    public Sale() {
        time = new Date();
        isComplete = false;
        cart = new ArrayList<>();
    }
    
    // Finalize the sale
    public void becomeComplete() {
        isComplete = true;
    }
    
    // Create a new item for the sale
    public void makeItem(String barcode) {
        cart.add(new SalesLineItem(barcode));
    }
    
    // Make a payment for this sale. Only 1 per sale
    public boolean makePayment(String type) {
        double total = getTotal();
        Payment payment = new Payment(type, total);
        payment.finalizePayment();
        return true;
    }
    
    // Get the total amount for this sale (no tax)
    public double getTotal() {
        double total = 0.0;
        for (SalesLineItem item: cart) {
            total += item.getSubtotal();
        }
        return total;
    }
}
